package fr.gjouneau.savm.framework.lang.semantics;

import java.util.List;

import fr.gjouneau.savm.framework.lang.SelfAdaptableLanguage;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;
import fr.gjouneau.savm.framework.lang.adaptation.ModuleRegistry;
import fr.gjouneau.savm.framework.module.adaptation.SelfAdaptationModule;

public interface AdaptableNode<Interface extends SemanticsAdaptationInterface> extends Node {
	public Interface defaultInterface();
	
	default public Object accept(SelfAdaptiveVisitor vis, Object executionContext) {
		FeedbackLoop<?,?> feedbackLoop = SelfAdaptableLanguage.INSTANCE().getFeedbackLoop();
		ModuleRegistry moduleRegistry = SelfAdaptableLanguage.INSTANCE().getAdaptationContext().getModuleRegistry();
		
		if(feedbackLoop.isTriggered(this)) {
			feedbackLoop.loop();
		}
		
		Interface config = defaultInterface();
		List<SelfAdaptationModule<?, ?, ?>> modules = moduleRegistry.getModulesFor(this.getClass());
		for (SelfAdaptationModule<?,?,?> m : modules) {
			SelfAdaptationModule<?,?,Interface> module = (SelfAdaptationModule<?, ?, Interface>) m;
			if(module.isActive()) {
				if(module.isTargetedNode(this)) {
					config = module.adapt(config);
					//return module.interpret(vis, this, executionContext);
				}
			}
		}
		
		return vis.dispatch(this, executionContext, config);
	}
}
