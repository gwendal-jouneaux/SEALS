package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant;

@Operationalize(node = IntConstant.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class IntConstantOp extends Operation<IntConstant> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, IntConstant e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Integer.valueOf(e.getValue());
	}

}