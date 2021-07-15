package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture;

@Operationalize(node = FunParamCapture.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class FunParamCaptureOp extends Operation<FunParamCapture> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, FunParamCapture e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return context.get(e.getVariable().getName());
	}

}