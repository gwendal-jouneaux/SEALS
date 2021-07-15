package miniJava.interpreter.miniJava.operations;

import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Null;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.ecore.EClass;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = Null.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class NullOp extends Operation<Null>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Null node, Object execCtx) {
		Value result;
		result = (Value) (MiniJavaFactory.eINSTANCE.createNullValue()) ;
		return result;
	}
}
