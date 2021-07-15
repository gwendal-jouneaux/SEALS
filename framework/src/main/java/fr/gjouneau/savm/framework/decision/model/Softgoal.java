package fr.gjouneau.savm.framework.decision.model;

import fr.gjouneau.savm.framework.decision.model.visitor.IGoalVisitor;

public class Softgoal extends GoalModelingElement {
	
	

	public Softgoal(String ID) {
		super(ID);
	}	

	@Override
	public <T> T accept(IGoalVisitor<T> visitor) {
		return visitor.visitSoftGoal(this);
	}

}
