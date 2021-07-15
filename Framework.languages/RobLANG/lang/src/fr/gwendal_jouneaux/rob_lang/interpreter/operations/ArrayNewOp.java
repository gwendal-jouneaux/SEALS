package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayNew;

@Operationalize(node = ArrayNew.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ArrayNewOp extends Operation<ArrayNew> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayNew e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		int _dimension = e.getDimension();
	    return new RuntimeArray(_dimension);
	}

}