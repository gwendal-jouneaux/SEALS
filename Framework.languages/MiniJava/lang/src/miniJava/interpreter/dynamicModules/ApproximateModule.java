package miniJava.interpreter.dynamicModules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.decision.model.Softgoal;
import fr.gjouneau.savm.framework.decision.model.TagConstraint.TAG;
import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import fr.gjouneau.savm.framework.decision.model.Task;
import fr.gjouneau.savm.framework.decision.model.Variable;
import fr.gjouneau.savm.framework.module.adaptation.SelfAdaptationModule;
import miniJava.interpreter.MiniJavaAdaptationContext;
import miniJava.interpreter.miniJava.ArrayAccess;
import miniJava.interpreter.miniJava.Assignee;
import miniJava.interpreter.miniJava.Assignment;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.ForStatement;
import miniJava.interpreter.miniJava.IfStatement;
import miniJava.interpreter.miniJava.Inferior;
import miniJava.interpreter.miniJava.InferiorOrEqual;
import miniJava.interpreter.miniJava.IntConstant;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.Plus;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;
import miniJava.interpreter.miniJava.Superior;
import miniJava.interpreter.miniJava.SuperiorOrEqual;
import miniJava.interpreter.miniJava.SymbolRef;
import miniJava.interpreter.miniJava.VariableDeclaration;
import miniJava.interpreter.miniJava.interfaces.ForInterface;

public class ApproximateModule extends SelfAdaptationModule<MiniJavaAdaptationContext, ForStatement, ForInterface> {

	private Map<Block, List<Statement>> arraysAssign;
	private Map<Block, List<Statement>> memoization;
	private Task perforationRate;
	private Task accuracyImpact;
	private Variable smallPR;
	private Variable PR;
	private Variable bigPR;
	
	public ApproximateModule() {
		super("ApproximateLoopUnrolling", ForStatement.class);
		arraysAssign = new HashMap();
	}
	
	private boolean verification(ForStatement self) {
		try {
			ForStatement loop = self;
			String symbolName = ((VariableDeclaration) loop.getDeclaration().getAssignee()).getName();
			
			boolean varUpdate = ((SymbolRef) loop.getProgression().getAssignee()).getSymbol().getName().equals(symbolName);
			boolean constIncL = (((Plus) loop.getProgression().getValue()).getLeft() instanceof IntConstant &&
					((SymbolRef) ((Plus) loop.getProgression().getValue()).getRight()).getSymbol().getName().equals(symbolName));
			boolean constIncR = (((Plus) loop.getProgression().getValue()).getRight() instanceof IntConstant &&
					((SymbolRef) ((Plus) loop.getProgression().getValue()).getLeft()).getSymbol().getName().equals(symbolName));
			boolean constInc = constIncL || constIncR;
			if(!(varUpdate && constInc)) return false;
			
			Plus plus = (Plus) loop.getProgression().getValue();
			
			ArrayList<Statement> arrayAssign = new ArrayList<Statement>();
			Block body = loop.getBlock();

			List<Statement> statements = body.getStatements();
			for (Statement st : statements) {
				if(st instanceof Assignment) {
					Assignee a = ((Assignment) st).getAssignee();
					if(a instanceof ArrayAccess && 
							((ArrayAccess) a).getIndex() instanceof SymbolRef &&
							((SymbolRef) ((ArrayAccess) a).getIndex()).getSymbol().getName().equals(symbolName)) {
						arrayAssign.add(st);
					}
				}
			}
			if (!arrayAssign.isEmpty()) {
				arraysAssign.put(body, arrayAssign);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	private Expression guard(Expression condition, Plus add) {
		Expression cond = EcoreUtil2.copy(condition);
		Plus copy = EcoreUtil2.copy(add);
		if(cond instanceof Inferior) {
			Inferior op = (Inferior) cond;
			op.setRight(copy);
		}
		if(cond instanceof Superior) {
			Superior op = (Superior) cond;	
			op.setLeft(copy);
		}
		if(cond instanceof InferiorOrEqual) {
			InferiorOrEqual op = (InferiorOrEqual) cond;
			op.setRight(copy);
		}
		if(cond instanceof SuperiorOrEqual) {
			SuperiorOrEqual op = (SuperiorOrEqual) cond;
			op.setLeft(copy);
		}
		return cond;
	}

	@Override
	public void init(MiniJavaAdaptationContext adaptationContext) {
		if(arraysAssign == null) {
			arraysAssign = new HashMap();
		}
		
		
		smallPR = new Variable("Small loop PR", 0);
		PR = new Variable("loop PR", 0);
		bigPR = new Variable("Big loop PR", 0);
		
		perforationRate = new Task("Perforation Rate");
		accuracyImpact = new Task("Accuracy Impact");
		
		perforationRate.addContribution(smallPR, 1.0 / 7.0);
		perforationRate.addContribution(PR, 2.0 / 7.0);
		perforationRate.addContribution(bigPR, 4.0 / 7.0);
		
		accuracyImpact.addContribution(smallPR, 1.0 / 21.0);
		accuracyImpact.addContribution(PR, 4.0 / 21.0);
		accuracyImpact.addContribution(bigPR, 16.0 / 21.0);
	}

	@Override
	public void connectSoftGoal(Softgoal softgoal) {
		if (softgoal.ID.equals("Performance")) {
			softgoal.addContribution(perforationRate, 0.25);
		}
		if (softgoal.ID.equals("Accuracy")) {
			softgoal.addContribution(accuracyImpact, -0.75);
		}
	}

	@Override
	public void connectResource(Resource resource) {
		if(resource.ID.equals("CPU_PERCENT")) {
			smallPR.addTag(resource, TAG.SUPERIOR, 0.25);
			PR.addTag(resource, TAG.SUPERIOR, 0.5);
			bigPR.addTag(resource, TAG.SUPERIOR, 0.75);
		}
	}

	@Override
	public ForInterface adapt(ForInterface configInterface) {
		int step = 0;
		if(bigPR.getValue(null) != 0) {
			step = 7;
		} else if(PR.getValue(null) != 0) {
			step = 3;
		} else if(smallPR.getValue(null) != 0) {
			step = 1;
		} 
		
		List<Statement> arrayAssign = arraysAssign.get(configInterface.getBlock());
		Assignment progress = EcoreUtil2.copy(configInterface.getProgression());
		Plus plus = (Plus) progress.getValue();
		
		int constIncr = 0;
		SymbolRef symbol = null;
		IntConstant newConst = MiniJavaFactory.eINSTANCE.createIntConstant();
		if(plus.getLeft() instanceof IntConstant) {
			constIncr = ((IntConstant) plus.getLeft()).getValue();
			symbol = ((SymbolRef) plus.getRight());
			plus.setLeft(newConst);
		} else {
			constIncr = ((IntConstant) plus.getRight()).getValue();
			symbol = ((SymbolRef) plus.getLeft());
			plus.setRight(newConst);
		}
		newConst.setValue(constIncr*(step+1));
		configInterface.setProgression(progress);
		
		List<Statement> toAdd = memoization.get(configInterface.getBlock());
		
		if(toAdd == null) {
			toAdd = new ArrayList<>();
			for (Statement st : arrayAssign) {
				for (int i = 0; i < 8; i++) {				
					// create _+const for i+const
					IntConstant integer = MiniJavaFactory.eINSTANCE.createIntConstant();
					Plus add = MiniJavaFactory.eINSTANCE.createPlus();
					integer.setValue(constIncr*(i+1));
					add.setRight(integer);
					add.setLeft(EcoreUtil2.copy(symbol));
					// copy assignment to avoid moving sub-tree
					Assignment copy = (Assignment) EcoreUtil2.copy(st);
					// save A[index] to put it on right side
					ArrayAccess pred = (ArrayAccess) EcoreUtil2.copy(( copy.getAssignee()));
					// A[index + (i+1)*const] = ...
					((ArrayAccess) copy.getAssignee()).setIndex(add);
					// ... = A[i]
					copy.setValue(pred);
					
					Expression guard = guard(configInterface.getCondition(), add);
					IfStatement iff = MiniJavaFactory.eINSTANCE.createIfStatement();
					iff.setExpression(guard);
					Block block = MiniJavaFactory.eINSTANCE.createBlock();
					block.getStatements().add(copy);
					iff.setThenBlock(block);
					
					toAdd.add(iff);
				}
			}
			memoization.put(configInterface.getBlock(), toAdd);
		}
		
		for (int i = 0; i < step; i++) {
			configInterface.addStatement(toAdd.get(i));
		}
		
		return configInterface;
	}

	@Override
	public boolean isTargetedNode(AdaptableNode<ForInterface> adaptableNode) {
		return adaptableNode instanceof ForStatement && (arraysAssign.get(((ForStatement) adaptableNode).getBlock()) != null || verification((ForStatement) adaptableNode));
	}

}
