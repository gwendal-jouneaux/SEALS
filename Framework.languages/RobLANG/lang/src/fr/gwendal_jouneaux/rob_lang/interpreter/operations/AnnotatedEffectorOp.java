package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.decision.model.Bounds;
import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedEffector;

@Operationalize(node = AnnotatedEffector.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class AnnotatedEffectorOp extends Operation<AnnotatedEffector> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, AnnotatedEffector e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Bounds b = new Bounds((Double) e.getLowerBound().accept(vis, context), (Double) e.getHigherBound().accept(vis, context));
		context.pushAdaptationBounds(e.getProperty().getLiteral(), b);
		Object out =  e.getStatement().accept(vis, context);
		context.popAdaptationBounds(e.getProperty().getLiteral());
		return out;
	}

}