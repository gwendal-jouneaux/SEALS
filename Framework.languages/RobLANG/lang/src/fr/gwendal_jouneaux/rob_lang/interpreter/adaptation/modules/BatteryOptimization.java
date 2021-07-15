package fr.gwendal_jouneaux.rob_lang.interpreter.adaptation.modules;

import fr.gjouneau.savm.framework.decision.model.Bounds;
import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.decision.model.Softgoal;
import fr.gjouneau.savm.framework.decision.model.TagConstraint.TAG;
import fr.gjouneau.savm.framework.decision.model.Task;
import fr.gjouneau.savm.framework.decision.model.Variable;
import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import fr.gjouneau.savm.framework.module.adaptation.SelfAdaptationModule;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface;
import fr.gwendal_jouneaux.rob_lang.robLANG.Move;
import fr.gwendal_jouneaux.rob_lang.robLANG.Turn;

public abstract class BatteryOptimization<AN extends AdaptableNode<MotorAdaptationInterface>> extends SelfAdaptationModule<ContextRobLANG, AN, MotorAdaptationInterface> {
	
	private Task timeImpact;
	private Task energy1;
	private Task energy2;
	private Task energy3;
	private Variable speedPercentage;
	private ContextRobLANG context;

	public BatteryOptimization(Class<? extends AdaptableNode<?>> clazz) {
		super("BatteryOptimization", clazz);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ContextRobLANG adaptationContext) {
		this.context = adaptationContext;
		
		speedPercentage = new Variable("Speed", 0.25, 1);
		Resource minusOne = new Resource("-1");
		minusOne.setMonitoredValue(-1);
		
		timeImpact = new Task("Time Impact");
		timeImpact.addContribution(speedPercentage, 1);
		timeImpact.addContribution(minusOne, 1);
		
		
		Resource zero65 = new Resource("0.65");
		zero65.setMonitoredValue(0.65);
		
		energy1 = new Task("Energy 1");             // [0.25, 0.5[ => -0.4 * time consumption + 0.65 = percentage of the max consumption of the motors
		energy1.addContribution(timeImpact, -0.4);
		energy1.addContribution(zero65, 1);
		energy1.addTag(speedPercentage, TAG.INFERIOR, 0.5);
		
		
		Resource zero15 = new Resource("0.15");
		zero15.setMonitoredValue(0.15);
		
		energy2 = new Task("Energy 2");             // [0.5, 0.75[ => -1.4 * time consumption + 0.15 = percentage of the max consumption of the motors
		energy2.addContribution(timeImpact, -1.4);
		energy1.addContribution(zero15, 1);
		energy2.addTag(speedPercentage, TAG.INFERIOR, 0.75);
		energy2.addTag(speedPercentage, TAG.SUPERIOR_EQ, 0.5);
		
		
		energy3 = new Task("Energy 3");            // [0.75, 1] => -2 * time consumption + 0 = percentage of the max consumption of the motors
		energy3.addContribution(timeImpact, -2);
		energy3.addTag(speedPercentage, TAG.SUPERIOR_EQ, 0.75);
	}

	@Override
	public void connectSoftGoal(Softgoal softgoal) {
		if (softgoal.ID.contains("Time")) {
			softgoal.addContribution(timeImpact, 1);
		}
		if (softgoal.ID.contains("Energy")) {
			softgoal.addContribution(energy1, 1);
			softgoal.addContribution(energy2, 1);
			softgoal.addContribution(energy3, 1);
		}
	}

	@Override
	public void connectResource(Resource resource) {
		if(resource.ID.equals("Battery")) {
			//timeImpact.addTag(resource, TAG.INFERIOR, 0.5);
		}
	}

	@Override
	public MotorAdaptationInterface adapt(MotorAdaptationInterface configInterface) {
		// Get dynamic values computed via the feedback loop
		Bounds b = this.context.getAdaptationBounds().get(speedPercentage.ID);
		double speedPercentageToaApply = speedPercentage.getValue(b);
		
		// Compute and change the speed to use for the move
		double effectiveSpeed = speedPercentageToaApply * this.context.getNominalSpeed();
		double delta = this.context.getSpeed() - effectiveSpeed;
		if(delta > 0.01) {
			configInterface.setBefore(new ChangeSpeedCommand(effectiveSpeed));
			configInterface.setAfter(new ChangeSpeedCommand(this.context.getNominalSpeed()));
		}
		
		return configInterface;
	}

	@Override
	public boolean isTargetedNode(AdaptableNode<MotorAdaptationInterface> adaptableNode) {
		return adaptableNode instanceof Move || adaptableNode instanceof Turn;
	}

}
