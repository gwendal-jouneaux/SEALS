package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseCompass;

@Operationalize(node = SenseCompass.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class SenseCompassOp extends Operation<SenseCompass> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SenseCompass e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Double.valueOf(context.getCompass());
	}

}