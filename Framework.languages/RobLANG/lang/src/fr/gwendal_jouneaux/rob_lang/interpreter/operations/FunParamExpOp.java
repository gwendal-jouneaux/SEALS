package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp;

@Operationalize(node = FunParamExp.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class FunParamExpOp extends Operation<FunParamExp> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, FunParamExp e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return e.getExpr().accept(vis, context);
	}

}