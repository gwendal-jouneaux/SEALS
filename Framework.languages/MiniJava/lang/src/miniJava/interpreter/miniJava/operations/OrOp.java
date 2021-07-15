package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Or;
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

@Operationalize(node = Or.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class OrOp extends Operation<Or>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Or node, Object execCtx) {
		Value result;
		BooleanValue left = ((BooleanValue) (((Expression) (node.getLeft())).accept(vis,(State) (execCtx))));
		BooleanValue right = ((BooleanValue) (((Expression) (node.getRight())).accept(vis,(State) (execCtx))));
		BooleanValue res = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		res.setValue(((left.isValue()) || (right.isValue())));
		result = (Value) (res) ;
		return result;
	}
}
