package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathCos;

@Operationalize(node = MathCos.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathCosOp extends Operation<MathCos> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathCos e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getExpression().accept(vis, context);
	    final Number value = ((Number) _interpretAdapt);
	    final double cos = Math.cos(Math.toRadians(value.doubleValue()));
	    return ((Double) Double.valueOf(cos));
	}

}