package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathAbs;

@Operationalize(node = MathAbs.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathAbsOp extends Operation<MathAbs> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathAbs e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getExpression().accept(vis, context);
	    final Number value = ((Number) _interpretAdapt);
	    final double abs = Math.abs(value.doubleValue());
	    return ((Double) Double.valueOf(abs));
	}

}