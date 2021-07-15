package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.DoubleExtensions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Divide;

@Operationalize(node = Divide.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class DivideOp extends Operation<Divide> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Divide e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		boolean _isDoubleType = context.typer.isDoubleType(context.typer.typeFor(e));
	    if (_isDoubleType) {
	      Object _interpretAdapt = e.getLeft().accept(vis, context);
	      Object _interpretAdapt_1 = e.getRight().accept(vis, context);
	      return Double.valueOf(DoubleExtensions.operator_divide(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
	    } else {
	      Object _interpretAdapt_2 = e.getLeft().accept(vis, context);
	      Object _interpretAdapt_3 = e.getRight().accept(vis, context);
	      return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() / (((Integer) _interpretAdapt_3)).intValue()));
	    }
	}

}