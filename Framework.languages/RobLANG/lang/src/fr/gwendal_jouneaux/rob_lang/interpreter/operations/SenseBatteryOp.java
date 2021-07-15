package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseBattery;

@Operationalize(node = SenseBattery.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class SenseBatteryOp extends Operation<SenseBattery> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SenseBattery e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		return Double.valueOf(context.getBattery());
	}

}