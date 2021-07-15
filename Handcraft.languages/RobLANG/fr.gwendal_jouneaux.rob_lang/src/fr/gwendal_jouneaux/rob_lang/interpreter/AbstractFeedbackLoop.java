package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.gwendal_jouneaux.rob_lang.interpreter.AbstractAdaptationModule.Strategy;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.Bounds;

public abstract class AbstractFeedbackLoop<Context extends AdaptationContext> {

	private List<AbstractAdaptationModule> modules;
	private Context context;
	private boolean overridingSemantics;
	
	protected AbstractFeedbackLoop() {
		modules = new ArrayList<>();
		context = null;
		overridingSemantics = true;
	}
	
	public void registerModule(AbstractAdaptationModule module) {
		getModules().add(module);
		context.registerModule(module);
	}
	
	public void reset() {
		modules = new ArrayList<>();
	}
	
	public void setContext(Context ctx) {
		context = ctx;
	}
	
	public Context getContext() {
		return context;
	}
	
	public AdaptationContext getAdaptationContext() {
		return context;
	}
	
	public boolean isOverridingSemantics() {
		//System.err.println("Override sementics : " + overridingSemantics);
		return overridingSemantics;
	}
	
	public final Object interpret(Object interpreter, EObject subjectNode, Object[] args) {
		if(loopTrigger(subjectNode)) {
			loop();
		}
		overridingSemantics = true;
		for (AbstractAdaptationModule module : getModules()) {
			if(module.isActive()) {
				if(module.isTargetedNode(subjectNode)) {
					//System.err.println("Module call");
					return module.interpret(interpreter, subjectNode, args);
				}
			}
		}
		overridingSemantics = false;
		return null;
	}
	
	/*
	public final boolean updateBefore(EObject subjectNode, Object[] args) {
		if(loopTrigger(subjectNode)) {
			loop();
		}
		boolean proceed = true;
		for (int i = 0; i < getModules().size(); i++) {
			AbstractAdaptationModule m = getModules().get(i);
			if(m.isActive()) {
				Map<String, Bounds> softgoalsBounds = context.getBounds();
				if(!m.isTargetedNode(subjectNode)) continue;
				if(m.callStrategy() == Strategy.BEFORE) {
					m.updateBefore(subjectNode, args);
				}
				if(m.callStrategy() == Strategy.AROUND) {
					proceed = m.updateBefore(subjectNode, args) && proceed;
				}
			}
		}
		return proceed;
	}
	
	public final Object updateAfter(EObject subjectNode, Object[] args, Object returned) {
		Object out = returned;
		for (int i = 0; i < getModules().size(); i++) {
			AbstractAdaptationModule m = getModules().get(i);
			if(m.isActive()) {
				if(!m.isTargetedNode(subjectNode)) continue;
				if(m.callStrategy() != Strategy.BEFORE) {
					if(m.updateAfter(subjectNode, args, returned)) {
						out = m.byPassResult();
					}
				}
			}
		}
		return out;
	}
	*/
	
	private final void loop() {
		System.out.println("MAPE-K LOOP");
		monitor();
		boolean needNewPlan = analyze();
		if(needNewPlan) {
			plan();
			execute();
		}
	}
	
	protected abstract boolean loopTrigger(EObject subjectNode);
	protected abstract void monitor();
	protected abstract boolean analyze();
	protected abstract void plan();
	protected abstract void execute();

	public List<AbstractAdaptationModule> getModules() {
		return modules;
	}

}
