package fr.gwendal_jouneaux.rob_lang.interpreter.model.goal;

import fr.gwendal_jouneaux.rob_lang.interpreter.model.goal.visitor.IGoalVisitor;

public final class Variable extends GoalModelingElement {
	
	private double lowerBound;
	private double higherBound;
	private double value;
	
	

	public Variable(String ID) {
		super(ID);
		this.setLowerBound(-1);
		this.setHigherBound(1);
	}
	
	public Variable(String ID, double lowerBound) {
		super(ID);
		this.setLowerBound(lowerBound);
		this.setHigherBound(1);
	}
	
	public Variable(String ID, double lowerBound, double higherBound) {
		super(ID);
		this.setLowerBound(lowerBound);
		this.setHigherBound(higherBound);
	}
	
	@Override
	public <T> T accept(IGoalVisitor<T> visitor) {
		return visitor.visitVariable(this);
	}
	
	@Override
	public void addContribution(GoalModelingElement elem, double impact){
		System.err.println("WARNING : Add contribution to a variable is unnecessary");
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}


	public double getHigherBound() {
		return higherBound;
	}

	private void setHigherBound(double higherBound) {
		this.higherBound = higherBound;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	private void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

}
