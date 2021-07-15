package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward;

@Operationalize(node = MoveBackward.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class MoveBackwardOp extends AdaptiveOperation<MoveBackward, MotorAdaptationInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MoveBackward e, Object execCtx, MotorAdaptationInterface config) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getDistance().accept(vis, context);
	    final Number dist = ((Number) _interpretAdapt);
	    System.out.println("Backward");
	    double _doubleValue = dist.doubleValue();
	    double _minus = (-_doubleValue);
	    if(config.getBefore() != null) config.getBefore().run(context);
	    context.moveRobot(_minus);
	    if(config.getAfter() != null) config.getAfter().run(context);
	    
	    return null;
	}

}