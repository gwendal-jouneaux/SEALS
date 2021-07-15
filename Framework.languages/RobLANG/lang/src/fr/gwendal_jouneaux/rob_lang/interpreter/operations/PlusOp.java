package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.DoubleExtensions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Plus;

@Operationalize(node = Plus.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class PlusOp extends Operation<Plus> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Plus e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		if ((context.typer.isStringType(context.typer.typeFor(e.getLeft())) || context.typer.isStringType(context.typer.typeFor(e.getRight())))) {
		      String _string = e.getLeft().accept(vis, context).toString();
		      String _string_1 = e.getRight().accept(vis, context).toString();
		      return (_string + _string_1);
		    } else {
		      boolean _isDoubleType = context.typer.isDoubleType(context.typer.typeFor(e));
		      if (_isDoubleType) {
		        Object _interpretAdapt = e.getLeft().accept(vis, context);
		        Object _interpretAdapt_1 = e.getRight().accept(vis, context);
		        return Double.valueOf(DoubleExtensions.operator_plus(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
		      } else {
		        Object _interpretAdapt_2 = e.getLeft().accept(vis, context);
		        Object _interpretAdapt_3 = e.getRight().accept(vis, context);
		        return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() + (((Integer) _interpretAdapt_3)).intValue()));
		      }
		    }
	}

}