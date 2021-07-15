package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight;

@Operationalize(node = TurnRight.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class TurnRightOp extends AdaptiveOperation<TurnRight, MotorAdaptationInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, TurnRight e, Object execCtx, MotorAdaptationInterface config) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getAngle().accept(vis, context);
	    final Number angle = ((Number) _interpretAdapt);
	    double _doubleValue = angle.doubleValue();
	    double _minus = (-_doubleValue);
	    if(config.getBefore() != null) config.getBefore().run(context);
	    context.turnRobot(_minus);
	    if(config.getAfter() != null) config.getAfter().run(context);
	    return null;
	}

}