package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant;

@Operationalize(node = StringConstant.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class StringConstantOp extends Operation<StringConstant> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, StringConstant e, Object execCtx) {
		return e.getValue();
	}

}