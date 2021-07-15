package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Greater;

@Operationalize(node = Greater.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class GreaterOp extends Operation<Greater> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Greater e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		boolean _isStringType = context.typer.isStringType(context.typer.typeFor(e.getLeft()));
	    if (_isStringType) {
	      Object _interpretAdapt = e.getLeft().accept(vis, context);
	      final String left = ((String) _interpretAdapt);
	      Object _interpretAdapt_1 = e.getRight().accept(vis, context);
	      final String right = ((String) _interpretAdapt_1);
	      return Boolean.valueOf((left.compareTo(right) > 0));
	    } else {
	      Object _interpretAdapt_2 = e.getLeft().accept(vis, context);
	      final Number left_1 = ((Number) _interpretAdapt_2);
	      Object _interpretAdapt_3 = e.getRight().accept(vis, context);
	      final Number right_1 = ((Number) _interpretAdapt_3);
	      double _doubleValue = left_1.doubleValue();
	      double _doubleValue_1 = right_1.doubleValue();
	      return Boolean.valueOf((_doubleValue > _doubleValue_1));
	    }
	}

}