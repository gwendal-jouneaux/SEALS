package miniJava.interpreter.miniJava.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import miniJava.interpreter.miniJava.ArrayLength;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;

@Operationalize(node = ArrayLength.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class ArrayLengthOp extends Operation<ArrayLength>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayLength node, Object execCtx) {
		Value result;
		ArrayRefValue arrayRef = ((ArrayRefValue) (((Expression) (node.getArray())).accept(vis,(State) (execCtx))));
		int size = ((int) (arrayRef.getInstance().getSize()));
		IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
		tmp.setValue(size);
		result = (Value) (tmp) ;
		return result;
	}
}
