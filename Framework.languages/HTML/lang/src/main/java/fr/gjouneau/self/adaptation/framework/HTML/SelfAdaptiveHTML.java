package fr.gjouneau.self.adaptation.framework.HTML;

import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

public class SelfAdaptiveHTML extends SelfAdaptableLanguage<HTMLAdaptationContext> {

	@Override
	protected HTMLAdaptationContext createAdaptationContext() {
		return new HTMLAdaptationContext();
	}

	@Override
	protected FeedbackLoop<?, HTMLAdaptationContext> createFeedbackLoop(HTMLAdaptationContext ctx) {
		return new HTMLFeedbackLoop(ctx);
	}

	@Override
	protected SelfAdaptiveVisitor createVisitor() {
		return new PrettyPrinter();
	}

}
