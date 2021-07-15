package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.gwendal_jouneaux.rob_lang.interpreter.decision.model.ModelEvaluationBounds;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Goal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.GoalModelingElement;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Resource;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Softgoal;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.TagConstraint.TAG;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.Variable;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.Bounds;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.FlattenedImpact;
import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.ModelFlatteningVisitor;

/**
 * IDynamicModule : Interface that define a dynamic module for the Dynamic Adaptive Pattern
 * @author gjouneau
 *
 */
public abstract class AbstractAdaptationModule {
	
	private Goal moduleTradeOff = null;
	private Variable active;
	
	public enum Strategy{
		BEFORE, AFTER, AROUND
	}
	
	
	public AbstractAdaptationModule(String moduleTradeOffName) {
		moduleTradeOff = new Goal(moduleTradeOffName);
		active = new Variable(moduleTradeOffName + " - Activation variable");
	}
	
	/**
	 * updateBefore : function called before execution of the node semantics
	 * @param self : The AST node that will be executed (one of the {@link IDynamicModule#targetedNodes()})
	 * @return true if the node need to be evaluated false to shortcut it 
	 * (shortcut only if {@link IDynamicModule#callStrategy() is AROUND})
	 */
	public abstract Object interpret(Object interpreter, EObject node, Object[] args);
	
	/**
	 * updateAfter : function called after execution of the node semantics
	 * @param self : The AST node that was executed (one of the {@link IDynamicModule#targetedNodes()})
	 * @param returned : The {@link Object} returned by the semantics
	 * @return true if you need to bypass the actual result 
	 * ({@link IDynamicModule#byPassResult()} will be called if true)
	 */
	//public abstract boolean updateAfter(EObject node, Object[] args, Object returned);
	
	/**
	 * byPassResult : function called when you bypass the result with 
	 * {@link IDynamicModule#updateAfter(IDynamicSubject, Object)}
	 * @return the Value you want to return (Warning : may be override by other modules)
	 */
	//public abstract Object byPassResult();
	
	/**
	 * targetedNodes : return the array of nodes ID concerned by this module
	 * @return array of nodes ID (Access using Package.YOUR_NODE)
	 */
	public abstract boolean isTargetedNode(EObject node);
	
	/**
	 * callStrategy : Choose the call strategy of the module. The strategy can be BEFORE or AFTER node execution,
	 * or AROUND(BEFORE & AFTER) allowing to choose if the semantics will be actually executed.
	 * @return The call strategy of the module
	 */
	//public abstract Strategy callStrategy();
	
	public final void afterRegister() {
		AdaptationContext adaptationContext = FeedbackLoop.INSTANCE().getAdaptationContext();
		
		init(adaptationContext);
		
		List<Resource> resources = adaptationContext.getResources();
		for (Resource resource : resources) {
			connectResource(resource);
		}
		
		String[] softgoalIDs = adaptationContext.softgoalIDs();
		for (int i = 0; i < softgoalIDs.length; i++) {
			Softgoal soft = new Softgoal(moduleTradeOff.ID + " - " + softgoalIDs[i]);
			adaptationContext.connectModuleSoftgoal(softgoalIDs[i], soft);
			moduleTradeOff.addContribution(soft, 1.0 / softgoalIDs.length);
			connectSoftGoal(soft);
			soft.addTag(active, TAG.SUPERIOR, 0.5);
			Map<GoalModelingElement, FlattenedImpact> fi = soft.accept(new ModelFlatteningVisitor());
			soft.setFlattenedImpact(fi);
		}
	}
	
	public final Goal getModuleTradeOff() {
		return moduleTradeOff;
	}
	
	public abstract void init(AdaptationContext adaptationContext);
	
	public abstract void connectSoftGoal(Softgoal softgoal);
	
	public abstract void connectResource(Resource resource);
	
	public final boolean isActive() {
		return active.getValue() > 0.5;
	}
	
	public final void activate(boolean activate) {
		active.setValue(activate ? 1 : 0);
	}
}
