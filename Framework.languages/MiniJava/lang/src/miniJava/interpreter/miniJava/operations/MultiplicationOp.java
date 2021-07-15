package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Multiplication;
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

@Operationalize(node = Multiplication.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class MultiplicationOp extends Operation<Multiplication>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Multiplication node, Object execCtx) {
		Value result;
		Value left = ((Value) (((Expression) (node.getLeft())).accept(vis,(State) (execCtx))));
		Value right = ((Value) (((Expression) (node.getRight())).accept(vis,(State) (execCtx))));
		if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				IntegerValue bleft = ((IntegerValue) (left));
				IntegerValue bright = ((IntegerValue) (right));
				IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
				tmp.setValue((bleft.getValue()) * (bright.getValue()));
				result = (Value) (tmp) ;
			}
			else {
				result = (Value) (null) ;
			}
		}
		else {
			result = (Value) (null) ;
		}
		return result;
	}
}
