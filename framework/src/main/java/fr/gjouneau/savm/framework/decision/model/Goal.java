package fr.gjouneau.savm.framework.decision.model;

import java.util.Set;

import fr.gjouneau.savm.framework.decision.model.visitor.IGoalVisitor;

public class Goal extends GoalModelingElement {

	public Goal(String ID) {
		super(ID);
	}
	
	public final void updateLink(String softgoalID, double newValue) {
		Set<GoalModelingElement> softs = getInputLinks().keySet();
		for (GoalModelingElement soft : softs) {
			if(soft.ID.equals(softgoalID)) {
				getInputLinks().put(soft, newValue);
				break;
			}
		}
	}

	@Override
	public <T> T accept(IGoalVisitor<T> visitor) {
		return visitor.visitGoal(this);
	}

}
