package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.RealVar;
import org.eclipse.emf.ecore.EObject;

import fr.gwendal_jouneaux.rob_lang.interpreter.AbstractAdaptationModule.Strategy;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Goal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Resource;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Variable;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.Bounds;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.ChocoTransformVisitor;


public class FeedbackLoop extends AbstractFeedbackLoop<ContextRobLANG>{
	// Static part for Singleton pattern
	private static FeedbackLoop instance;
	
	public static synchronized FeedbackLoop INSTANCE() {
       if (instance == null) {
          instance = new FeedbackLoop();
       }

       return instance;
    }
	
	// Start of the FeedbackLoop Class
	
	private long time;
	Map<String, Double> userConfig;
	Map<Resource, Double> resourcesValues;
	Map<RealVar, Variable> variables;
	Solution solution;
	
	private FeedbackLoop() {
		this.time = 0;
		this.resourcesValues = new HashMap();
	}
	
	protected final boolean loopTrigger(EObject subjectNode) {
		long delta = System.currentTimeMillis()-time;
		if(delta > 3000) {
			time = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}
	
	protected final void monitor() {
		this.userConfig = getContext().loadUserConfig();
		List<Resource> resources = getContext().getResources();
		for (Resource resource : resources) {
			if (resource.ID.equals("Battery")) {
				resourcesValues.put(resource, getContext().getBattery() / 10000);
			} 
		}
	}
	
	protected final boolean analyze() {
		Map<String, Double> oldUserConfig = getContext().getUserConfig();
		if(oldUserConfig == null) return true;
		
		for (String id : userConfig.keySet()) {
			double delta = Math.abs(userConfig.get(id) - oldUserConfig.get(id));
			if(delta > 0.01) {
				return true;
			}
		}
		
		double error = 0.0;
		for (Resource resource : resourcesValues.keySet()) {
			double delta = Math.abs(resource.monitor()*100 - resourcesValues.get(resource)*100);
			double square = delta * delta;
			error += square;
		}
		error = error / resourcesValues.size();
		
		return error > 3;
	}
	
	protected final void plan() {
		// apply change to runtime models
		getContext().setUserConfig(this.userConfig);
		for (Resource resource : resourcesValues.keySet()) {
			resource.setMonitoredValue(resourcesValues.get(resource));
		}
		
		Goal tradeOff = getContext().getGoal();
		
		Map<String, Bounds> softgoalsBounds = getContext().getBounds();
		ChocoTransformVisitor v = new ChocoTransformVisitor(softgoalsBounds);
		RealVar tradeoffVar = tradeOff.accept(v);
		Model chocoModel = v.getModel();
		variables = v.getVariables();
		
		// to maximize Trade-off
		chocoModel.setObjective(Model.MAXIMIZE, tradeoffVar);
		Solver solver = chocoModel.getSolver();
		solution = new Solution(chocoModel);
		while (solver.solve()) {
			// an improving solution has been found
		    solution.record();
		}
	}
	
	protected final void execute() {
		AbstractAdaptationModule batteryOptim = getModules().get(0);
		for(Variable v : variables.values()) {
			System.err.println("---->" + v.ID);
			v.setValue(0.25);
		}
		batteryOptim.activate(true);
		
		return;
		/*
		if(solution.exists()) {
			System.out.println("Choco found a solution");
			for (RealVar var : variables.keySet()) {
				double[] bounds = solution.getRealBounds(var);
				double value = (bounds[0] + bounds[1]) / 2;
				Variable GMvar = variables.get(var);
				GMvar.setValue(value);
			}
		} else {
			System.out.println("Choco did not found a solution");
			List<AbstractAdaptationModule> modules = getModules();
			for (AbstractAdaptationModule module : modules) {
				module.activate(false);
			}			
		}*/
	}

}
