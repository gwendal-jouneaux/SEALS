package fr.gwendal_jouneaux.rob_lang.interpreter;

import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

public class SelfAdaptableRobLANG extends SelfAdaptableLanguage<ContextRobLANG> {
	private static ContextRobLANG createdContext;
	
	public static void initContext(ContextRobLANG createdContext) {
		SelfAdaptableRobLANG.createdContext = createdContext;
	}

	@Override
	protected ContextRobLANG createAdaptationContext() {
		return SelfAdaptableRobLANG.createdContext;
	}

	@Override
	protected FeedbackLoop<?, ContextRobLANG> createFeedbackLoop(ContextRobLANG ctx) {
		return new RobLANGFeedbackLoop(ctx);
	}

	@Override
	protected SelfAdaptiveVisitor createVisitor() {
		return new RobLANGVisitor();
	}

}
