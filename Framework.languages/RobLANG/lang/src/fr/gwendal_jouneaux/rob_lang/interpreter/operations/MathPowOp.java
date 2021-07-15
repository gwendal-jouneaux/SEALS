package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathPow;

@Operationalize(node = MathPow.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathPowOp extends Operation<MathPow> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathPow e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getValue().accept(vis, context);
	    final Number value = ((Number) _interpretAdapt);
	    Object _interpretAdapt_1 = e.getExponant().accept(vis, context);
	    final Number exp = ((Number) _interpretAdapt_1);
	    double _pow = Math.pow(value.doubleValue(), exp.doubleValue());
	    return ((Double) Double.valueOf(_pow));
	}

}