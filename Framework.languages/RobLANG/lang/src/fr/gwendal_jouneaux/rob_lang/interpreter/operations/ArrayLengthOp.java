package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength;

@Operationalize(node = ArrayLength.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ArrayLengthOp extends Operation<ArrayLength> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayLength e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getArray().accept(vis, context);
	    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
	    return Integer.valueOf(a.length());
	}

}