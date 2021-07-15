package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft;

@Operationalize(node = MoveForward.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MoveForwardOp extends AdaptiveOperation<MoveForward, MotorAdaptationInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MoveForward e, Object execCtx, MotorAdaptationInterface config) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getDistance().accept(vis, context);
	    final Number dist = ((Number) _interpretAdapt);
	    if(config.getBefore() != null) config.getBefore().run(context);
	    context.moveRobot(dist.doubleValue());
	    if(config.getAfter() != null) config.getAfter().run(context);
	    
	    return null;
	}

}