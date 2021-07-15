package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringConstant;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = StringConstant.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class StringConstantOp extends Operation<StringConstant>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, StringConstant node, Object execCtx) {
		Value result;
		StringValue ret = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
		ret.setValue(node.getValue());
		result = (Value) (ret) ;
		return result;
	}
}
