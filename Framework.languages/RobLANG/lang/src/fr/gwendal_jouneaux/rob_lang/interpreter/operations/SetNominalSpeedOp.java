package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.SetNominalSpeed;

@Operationalize(node = SetNominalSpeed.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class SetNominalSpeedOp extends Operation<SetNominalSpeed> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SetNominalSpeed e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getSpeed().accept(vis, context);
	    final Number speed = ((Number) _interpretAdapt);
	    context.setNominalSpeed(speed.doubleValue());
	    return null;
	}

}