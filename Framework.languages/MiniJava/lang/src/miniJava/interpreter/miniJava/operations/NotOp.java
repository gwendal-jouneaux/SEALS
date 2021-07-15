package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Not;
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

@Operationalize(node = Not.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class NotOp extends Operation<Not>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Not node, Object execCtx) {
		Value result;
		BooleanValue left = ((BooleanValue) (((Expression) (node.getExpression())).accept(vis,(State) (execCtx))));
		BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmp.setValue(!(left.isValue()));
		result = (Value) (tmp) ;
		return result;
	}
}
