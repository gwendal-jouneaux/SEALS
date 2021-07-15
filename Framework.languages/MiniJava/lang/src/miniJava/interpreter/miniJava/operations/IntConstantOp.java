package miniJava.interpreter.miniJava.operations;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.IntConstant;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = IntConstant.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class IntConstantOp extends Operation<IntConstant>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, IntConstant node, Object execCtx) {
		Value result;
		IntegerValue ret = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
		ret.setValue(node.getValue());
		result = (Value) (ret) ;
		return result;
	}
}
