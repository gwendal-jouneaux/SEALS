package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Sqrt;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import minijava.MathService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = Sqrt.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class SqrtOp extends Operation<Sqrt>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Sqrt node, Object execCtx) {
		Value result;
		Value expression = ((Value) (((Expression) (node.getExpression())).accept(vis,(State) (execCtx))));
		if (expression instanceof IntegerValue) {
			IntegerValue number = ((IntegerValue) (expression));
			IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
			tmp.setValue(MathService.sqrt((Sqrt) (node), (int) (number.getValue())));
			result = (Value) (tmp) ;
		}
		else {
			result = (Value) (null) ;
		}
		return result;
	}
}
