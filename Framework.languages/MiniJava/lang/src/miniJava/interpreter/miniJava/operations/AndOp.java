package miniJava.interpreter.miniJava.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import miniJava.interpreter.miniJava.And;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;

@Operationalize(node = And.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class AndOp extends Operation<And>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, And node, Object execCtx) {
		Value result;
		Value left = ((Value) (((Expression) (node.getLeft())).accept(vis,(State) (execCtx))));
		Value right = ((Value) (((Expression) (node.getRight())).accept(vis,(State) (execCtx))));
		if (left instanceof BooleanValue) {
			if (right instanceof BooleanValue) {
				BooleanValue bleft = ((BooleanValue) (left));
				BooleanValue bright = ((BooleanValue) (right));
				BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				tmp.setValue(((bleft.isValue()) && (bright.isValue())));
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
