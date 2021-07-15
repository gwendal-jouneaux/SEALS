package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.SensePosition;

@Operationalize(node = SensePosition.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class SensePositionOp extends Operation<SensePosition> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SensePosition e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		final RuntimeArray array = new RuntimeArray(1);
	    final double[] pos = context.getPosition();
	    for (final double axis : pos) {
	      array.add(Double.valueOf(axis));
	    }
	    return array;
	}

}