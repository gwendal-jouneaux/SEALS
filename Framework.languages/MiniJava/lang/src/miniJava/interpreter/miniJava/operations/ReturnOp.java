package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Return;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = Return.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class ReturnOp extends Operation<Return>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Return node, Object execCtx) {
		Value value = ((Value) (((Expression) (node.getExpression())).accept(vis,(State) (execCtx))));
		((State) (execCtx)).findCurrentFrame().setReturnValue(value);
		return null;
	}
}
