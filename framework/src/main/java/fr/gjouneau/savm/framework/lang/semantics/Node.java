package fr.gjouneau.savm.framework.lang.semantics;

import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;

public interface Node {
	default public Object accept(SelfAdaptiveVisitor vis, Object executionContext) {
		FeedbackLoop<?,?> feedbackLoop = SelfAdaptableLanguage.INSTANCE().getFeedbackLoop();
		
		if(feedbackLoop.isTriggered(this)) {
			feedbackLoop.loop();
		}
		return vis.dispatch(this, executionContext);
	}
}
