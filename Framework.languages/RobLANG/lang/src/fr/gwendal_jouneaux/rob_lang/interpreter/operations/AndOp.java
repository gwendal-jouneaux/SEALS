package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.And;

@Operationalize(node = And.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class AndOp extends Operation<And> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, And e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Boolean.valueOf(((((Boolean) e.getLeft().accept(vis, context))).booleanValue() && (((Boolean) e.getRight().accept(vis, context))).booleanValue()));
	}

}