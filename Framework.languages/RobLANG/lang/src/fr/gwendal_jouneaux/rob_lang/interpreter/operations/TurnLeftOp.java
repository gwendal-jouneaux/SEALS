package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft;

@Operationalize(node = TurnLeft.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class TurnLeftOp extends AdaptiveOperation<TurnLeft, MotorAdaptationInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, TurnLeft e, Object execCtx, MotorAdaptationInterface config) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getAngle().accept(vis, context);
	    final Number angle = ((Number) _interpretAdapt);
	    if(config.getBefore() != null) config.getBefore().run(context);
	    context.turnRobot(angle.doubleValue());
	    if(config.getAfter() != null) config.getAfter().run(context);
	    return null;
	}

}