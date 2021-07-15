package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Goal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Resource;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Softgoal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.Bounds;


public abstract class AdaptationContext {
	private Map<String, Double> userConfig;
	private List<Resource> resources;
	private List<Goal> tradeOffByModule;
	private Goal tradeOff;
	private Map<String, Softgoal> softgoals;
	private Map<String, List<Bounds>> adaptationBounds;

	public AdaptationContext() {
		tradeOff = new Goal("GlobalTradeOff");
		resources = new ArrayList<Resource>();
		for (Resource resource : createResources()) {
			resources.add(resource);
		}
		tradeOffByModule = new ArrayList<Goal>();
		adaptationBounds = new HashMap<>();
		softgoals = new HashMap<>();
		for (String softgoalID : softgoalIDs()) {
			List<Bounds> bounds = new ArrayList<>();
			bounds.add(new Bounds(-1, 1));
			adaptationBounds.put(softgoalID, bounds);
			Softgoal soft = new Softgoal(softgoalID);
			tradeOff.addContribution(soft, 1/softgoalIDs().length);
			softgoals.put(softgoalID, soft);
		}
		
	}
	
	final void registerModule(AbstractAdaptationModule module) {
		module.afterRegister();
		tradeOffByModule.add(module.getModuleTradeOff());
		//tradeOff.addContribution(module.getModuleTradeOff(), 1.0);
	}
	
	final void connectModuleSoftgoal(String id, Softgoal soft) {
		softgoals.get(id).addContribution(soft, 1);
	}
	
	final Map<String, Double> getUserConfig() {
		return userConfig;
	}

	final void setUserConfig(Map<String, Double> userConfig) {
		this.userConfig = userConfig;
		for (String id : userConfig.keySet()) {
			tradeOff.updateLink(id, userConfig.get(id));
		}
	}
	
	public final List<Resource> getResources() {
		return resources;
	}
	
	final List<Goal> getTradeOffByModule() {
		return tradeOffByModule;
	}
	
	final Goal getGoal() {
		return tradeOff;
	}
	
	public final void pushAdaptationBounds(String property, double low, double high) {
		List<Bounds> bounds = adaptationBounds.get(property);
		bounds.add(new Bounds(low, high));
	}
	
	public final void popAdaptationBounds(String property) {
		List<Bounds> bounds = adaptationBounds.get(property);
		bounds.remove(bounds.size()-1);
	}
	
	public final Map<String, Bounds> getBounds() {
		Map<String, Bounds> out = new HashMap<>();
		for (String softgoalID : softgoalIDs()) {
			List<Bounds> allBounds = adaptationBounds.get(softgoalID);
			Bounds outBounds = allBounds.get(0);
			for (Bounds bounds : allBounds) {
				outBounds = outBounds.intersection(bounds);
			}
			out.put(softgoalID, outBounds);
		}
		return out;
	}

	public abstract Map<String, Double> loadUserConfig();
	
	public abstract String[] softgoalIDs();
	
	protected abstract Resource[] createResources();
}
