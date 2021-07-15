package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant;

@Operationalize(node = BoolConstant.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class BoolConstantOp extends Operation<BoolConstant> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, BoolConstant e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Boolean.valueOf(Boolean.parseBoolean(e.getValue()));
	}

}