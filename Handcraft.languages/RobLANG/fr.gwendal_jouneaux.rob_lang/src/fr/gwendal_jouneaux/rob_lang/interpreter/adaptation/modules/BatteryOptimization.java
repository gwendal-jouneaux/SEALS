package fr.gwendal_jouneaux.rob_lang.interpreter.adaptation.modules;

import org.eclipse.emf.ecore.EObject;

import fr.gwendal_jouneaux.rob_lang.interpreter.AbstractAdaptationModule;
import fr.gwendal_jouneaux.rob_lang.interpreter.AdaptationContext;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.InterpretRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Resource;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Softgoal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Task;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Variable;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.TagConstraint.TAG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Expression;
import fr.gwendal_jouneaux.rob_lang.robLANG.Move;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward;
import fr.gwendal_jouneaux.rob_lang.robLANG.Turn;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight;

public class BatteryOptimization extends AbstractAdaptationModule {
	
	private Task timeImpact;
	private Task energy1;
	private Task energy2;
	private Task energy3;
	
	private Variable speedPercentage;

	public BatteryOptimization() {
		super("Battery Optimization");
	}
	
	@Override
	public Object interpret(Object interpreter, EObject node, Object[] args) {
		// Get dynamic values computed via the feedback loop
		double speedPercentageToaApply = speedPercentage.getValue();
		
		// Compute and change the speed to use for the move
		ContextRobLANG ctx = (ContextRobLANG) args[1];
		double effectiveSpeed = speedPercentageToaApply * ctx.getNominalSpeed();
		double delta = ctx.getSpeed() - effectiveSpeed;
		boolean speedChanged = false;
		if(delta > 0.01) {
			ctx.setSpeed(effectiveSpeed);
			speedChanged = true;
		}
		
		Number out = null;
		if(node instanceof Move) {
			out = (Number) ((InterpretRobLANG) interpreter).interpret(((Move) node).getDistance(), ctx);
			ctx.moveRobot(out.doubleValue());
		} else {
			out = (Number) ((InterpretRobLANG) interpreter).interpret(((Turn) node).getAngle(), ctx);
			ctx.turnRobot(out.doubleValue());
		}
		
		// Clean the speed after the move
		if(speedChanged) {
			ctx.setSpeed(ctx.getNominalSpeed());
		}
		
		return out;
	}

	@Override
	public boolean isTargetedNode(EObject node) {
		return node instanceof Move || node instanceof Turn;
	}

	@Override
	public void init(AdaptationContext adaptationContext) {
		speedPercentage = new Variable("Speed percentage", 0.25, 1);
		Resource minusOne = new Resource("-1");
		minusOne.setMonitoredValue(-1);
		
		timeImpact = new Task("Time Impact");
		timeImpact.addContribution(speedPercentage, 1);
		timeImpact.addContribution(minusOne, 1);
		
		
		Resource zero65 = new Resource("0.65");
		zero65.setMonitoredValue(0.65);
		
		energy1 = new Task("Energy 1");             // [0.25, 0.5] => -0.4 * time consumption + 0.65 = percentage of the max consumption of the motors
		energy1.addContribution(timeImpact, -0.4);
		energy1.addContribution(zero65, 1);
		energy1.addTag(speedPercentage, TAG.INFERIOR, 0.5);
		
		
		Resource zero15 = new Resource("0.15");
		zero15.setMonitoredValue(0.15);
		
		energy2 = new Task("Energy 2");             // [0.5, 0.75] => -1.4 * time consumption + 0.15 = percentage of the max consumption of the motors
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

}
