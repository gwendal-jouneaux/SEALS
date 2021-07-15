package miniJava.interpreter;

import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

public class SelfAdaptiveMinJava extends SelfAdaptableLanguage<MiniJavaAdaptationContext> {

	@Override
	protected MiniJavaAdaptationContext createAdaptationContext() {
		return new MiniJavaAdaptationContext();
	}

	@Override
	protected FeedbackLoop<?, MiniJavaAdaptationContext> createFeedbackLoop(MiniJavaAdaptationContext ctx) {
		return new MiniJavaFeedbackLoop(ctx);
	}

	@Override
	protected SelfAdaptiveVisitor createVisitor() {
		return new MiniJavaVisitor();
	}

}
