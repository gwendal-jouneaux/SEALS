package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import com.google.common.base.Objects;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Equality;

@Operationalize(node = Equality.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class EqualityOp extends Operation<Equality> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Equality e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getLeft().accept(vis, context);
	    Object _interpretAdapt_1 = e.getRight().accept(vis, context);
	    return Boolean.valueOf(Objects.equal(_interpretAdapt, _interpretAdapt_1));
	}

}