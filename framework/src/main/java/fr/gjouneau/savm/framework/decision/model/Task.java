package fr.gjouneau.savm.framework.decision.model;

import fr.gjouneau.savm.framework.decision.model.visitor.IGoalVisitor;

public class Task extends GoalModelingElement {

	public Task(String ID) {
		super(ID);
	}

	@Override
	public <T> T accept(IGoalVisitor<T> visitor) {
		return visitor.visitTask(this);
	}

}
