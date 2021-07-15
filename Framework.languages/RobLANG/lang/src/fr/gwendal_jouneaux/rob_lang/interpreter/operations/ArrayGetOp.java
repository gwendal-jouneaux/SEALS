package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet;

@Operationalize(node = ArrayGet.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ArrayGetOp extends Operation<ArrayGet> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayGet e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getArray().accept(vis, context);
	    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
	    Object _interpretAdapt_1 = e.getIndex().accept(vis, context);
	    return a.get((((Integer) _interpretAdapt_1)).intValue());
	}

}