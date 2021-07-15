package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathSqrt;

@Operationalize(node = MathSqrt.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathSqrtOp extends Operation<MathSqrt> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathSqrt e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getExpression().accept(vis, context);
	    final Number square = ((Number) _interpretAdapt);
	    final double root = Math.sqrt(square.doubleValue());
	    return ((Double) Double.valueOf(root));
	}

}