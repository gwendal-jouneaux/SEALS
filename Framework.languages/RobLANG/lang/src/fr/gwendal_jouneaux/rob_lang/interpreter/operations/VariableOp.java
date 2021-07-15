package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Variable;

@Operationalize(node = Variable.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class VariableOp extends Operation<Variable> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Variable e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		final Object value = e.getExpression().accept(vis, context);
	    context.put(e.getName(), value);
	    return value;
	}

}