package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IfStatement;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = IfStatement.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class IfStatementOp extends Operation<IfStatement>{
	
	@Override
	public Object execute(SelfAdaptiveVisitor vis, IfStatement node, Object execCtx) {
		BooleanValue booleanValue = ((BooleanValue) (((BooleanValue) (((Expression) (node.getExpression())).accept(vis,(State) (execCtx))))));
		if (booleanValue.isValue()) {
			((Block) (node.getThenBlock())).accept(vis,(State) (execCtx));
		}
		else {
			if (!EqualService.equals((node.getElseBlock()), (null))) {
				((Block) (node.getElseBlock())).accept(vis,(State) (execCtx));
			}
		}
		return null;
	}
}
