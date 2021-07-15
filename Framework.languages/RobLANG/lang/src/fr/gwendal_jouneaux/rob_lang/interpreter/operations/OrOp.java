package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Or;

@Operationalize(node = Or.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class OrOp extends Operation<Or> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Or e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Boolean.valueOf(((((Boolean) e.getLeft().accept(vis, context))).booleanValue() || (((Boolean) e.getRight().accept(vis, context))).booleanValue()));
	}

}