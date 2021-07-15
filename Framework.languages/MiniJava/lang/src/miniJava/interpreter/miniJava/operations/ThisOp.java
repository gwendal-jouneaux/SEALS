package miniJava.interpreter.miniJava.operations;

import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.This;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = This.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class ThisOp extends Operation<This>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, This node, Object execCtx) {
		Value result;
		ObjectInstance currentInstance = ((ObjectInstance) (((State) (execCtx)).findCurrentFrame().getInstance()));
		ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(currentInstance);
		result = (Value) (tmp) ;
		return result;
	}
}
