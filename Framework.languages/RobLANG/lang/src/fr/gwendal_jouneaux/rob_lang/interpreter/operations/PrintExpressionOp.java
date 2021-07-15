package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.InputOutput;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression;

@Operationalize(node = PrintExpression.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class PrintExpressionOp extends Operation<PrintExpression> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, PrintExpression e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		final Object value = e.getExpression().accept(vis, context);
	    context.getTime();
	    InputOutput.<Object>println(value);
	    return value;
	}

}