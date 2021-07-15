package fr.gwendal_jouneaux.rob_lang.interpreter.model.goal;

import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.IGoalVisitor;

public class Task extends GoalModelingElement {

	public Task(String ID) {
		super(ID);
	}

	@Override
	public <T> T accept(IGoalVisitor<T> visitor) {
		return visitor.visitTask(this);
	}

}
