package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo;

@Operationalize(node = MathModulo.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MathModuloOp extends Operation<MathModulo> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MathModulo e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getLhs().accept(vis, context);
	    final Number lhs = ((Number) _interpretAdapt);
	    Object _interpretAdapt_1 = e.getRhs().accept(vis, context);
	    final Number rhs = ((Number) _interpretAdapt_1);
	    double _doubleValue = lhs.doubleValue();
	    double _doubleValue_1 = rhs.doubleValue();
	    double _modulo = (_doubleValue % _doubleValue_1);
	    return ((Double) Double.valueOf(_modulo));
	}

}