package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArraySet;

@Operationalize(node = ArraySet.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ArraySetOp extends Operation<ArraySet> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArraySet e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getArray().accept(vis, context);
	    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
	    Object _interpretAdapt_1 = e.getIndex().accept(vis, context);
	    a.set((((Integer) _interpretAdapt_1)).intValue(), e.getValue().accept(vis, context));
	    return null;
	}

}