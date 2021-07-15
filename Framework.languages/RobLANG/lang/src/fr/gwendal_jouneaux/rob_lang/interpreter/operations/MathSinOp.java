package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathSin;

@Operationalize(node = MathSin.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathSinOp extends Operation<MathSin> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathSin e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getExpression().accept(vis, context);
	    final Number value = ((Number) _interpretAdapt);
	    final double sin = Math.sin(Math.toRadians(value.doubleValue()));
	    return ((Double) Double.valueOf(sin));
	}

}