package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.WhileStatement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = WhileStatement.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class WhileStatementOp extends Operation<WhileStatement>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, WhileStatement node, Object execCtx) {
		BooleanValue continueWhile = ((BooleanValue) (((BooleanValue) (((Expression) (node.getCondition())).accept(vis,(State) (execCtx))))));
		while (continueWhile.isValue()) {
			((Block) (node.getBlock())).accept(vis,(State) (execCtx));
			BooleanValue continueWhile2 = ((BooleanValue) (((BooleanValue) (((Expression) (node.getCondition())).accept(vis,(State) (execCtx))))));
			continueWhile = continueWhile2;
		}
		return null;
	}
}
