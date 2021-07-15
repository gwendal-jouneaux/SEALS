package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Frame;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Statement;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = Block.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class BlockOp extends Operation<Block>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Block node, Object execCtx) {
		((State) (execCtx)).pushNewContext();
		Frame currentFrame = ((Frame) (((State) (execCtx)).findCurrentFrame()));
		int lgt = ((int) (CollectionService.size(node.getStatements())));
		int i = ((int) (0));
		while ((((i) < (lgt)) && (EqualService.equals((currentFrame.getReturnValue()), (null))))) {
			((Statement) (CollectionService.get(node.getStatements(), i))).accept(vis,(State) (execCtx));
			i = (i) + (1);
		}
		Context out = ((State) (execCtx)).findCurrentContext();
		((State) (execCtx)).popCurrentContext();
		return out;
	}
}
