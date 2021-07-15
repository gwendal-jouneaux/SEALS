package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.RealVar;

import fr.gjouneau.savm.framework.decision.model.Bounds;
import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.decision.model.Variable;
import fr.gjouneau.savm.framework.decision.model.visitor.ChocoTransformVisitor;
import fr.gjouneau.savm.framework.lang.adaptation.FeedbackLoop;
import fr.gjouneau.savm.framework.lang.semantics.Node;
import fr.gjouneau.savm.framework.module.adaptation.SelfAdaptationModule;


public class RobLANGFeedbackLoop extends FeedbackLoop<SelfAdaptableRobLANG, ContextRobLANG>{

	private long time;
	Map<String, Double> userConfig;
	Map<Resource, Double> resourcesValues;
	Map<RealVar, Variable> variables;
	Solution solution;
	
	public RobLANGFeedbackLoop(ContextRobLANG adaptationCtx) {
		super(adaptationCtx);
		this.time = 0;
		this.resourcesValues = new HashMap();
	}
	
	protected final void monitor() {
		this.userConfig = getAdaptationContext().readExpectedTradeOff();
		List<Resource> resources = getAdaptationContext().getEnvironmentModel();
		for (Resource resource : resources) {
			if (resource.ID.equals("Battery")) {
				resourcesValues.put(resource, getAdaptationContext().getBattery() / 10000);
			} 
		}
	}
	
	protected final boolean analyze() {
		Map<String, Double> oldUserConfig = getAdaptationContext().getExpectedTradeOff();
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
		getAdaptationContext().setExpectedTradeOff(this.userConfig);
		for (Resource resource : resourcesValues.keySet()) {
			resource.setMonitoredValue(resourcesValues.get(resource));
		}
		
		Map<String, Bounds> bounds = getAdaptationContext().getAdaptationBounds();
		ChocoTransformVisitor v = new ChocoTransformVisitor(bounds);
		RealVar tradeoffVar = getAdaptationContext().evaluateModelWith(v);
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
		/*SelfAdaptationModule<?, ?, ?> batteryOptim = getAdaptationContext().getModuleRegistry().getModules().get(0);
		for(Variable v : variables.values()) {
			System.err.println("---->" + v.ID);
			v.setValue(0.25);
		}
		batteryOptim.setActive(true);
		
		return;*/
		
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
			List<SelfAdaptationModule<?, ?, ?>> modules = getAdaptationContext().getModuleRegistry().getModules();
			for (SelfAdaptationModule<?, ?, ?> module : modules) {
				module.setActive(false);
			}			
		}
	}

	@Override
	public boolean isTriggered(Node n) {
		long delta = System.currentTimeMillis()-time;
		if(delta > 3000) {
			time = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}

}
