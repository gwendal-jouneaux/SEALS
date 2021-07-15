package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import miniJava.interpreter.miniJava.BoolConstant;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = BoolConstant.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class BoolConstantOp extends Operation<BoolConstant>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, BoolConstant node, Object execCtx) {
		Value result;
		BooleanValue ret = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		ret.setValue(EqualService.equals((node.getValue()), ("true")));
		result = (Value) (ret) ;
		return result;
	}
}
