package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd;
import fr.gwendal_jouneaux.rob_lang.robLANG.Expression;

@Operationalize(node = ArrayAdd.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ArrayAddOp extends Operation<ArrayAdd> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayAdd e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getArray().accept(vis, context);
	    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
	    Expression _indexedValue = e.getIndexedValue();
	    boolean _tripleEquals = (_indexedValue == null);
	    if (_tripleEquals) {
	      a.add(e.getValueOrIndex().accept(vis, context));
	    } else {
	      Object _interpretAdapt_1 = e.getValueOrIndex().accept(vis, context);
	      a.add((((Integer) _interpretAdapt_1)).intValue(), e.getIndexedValue().accept(vis, context));
	    }
	    return null;
	}

}