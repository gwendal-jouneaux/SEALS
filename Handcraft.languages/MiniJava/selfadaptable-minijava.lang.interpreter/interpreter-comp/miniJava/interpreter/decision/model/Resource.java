package miniJava.interpreter.decision.model;

import java.util.HashSet;
import java.util.Set;

public final class Resource extends ModelingElement {

	public Resource(String ID) {
		super(ID);
	}
	
	public void setValue(double val) {
		value = val;
	}
	
	final protected void clean() {
	}
	
	@Override
	protected Set<Variable> assessVariables(Double pathImpact) {
		return new HashSet<Variable>();
	}
	
	@Override
	protected Double evaluate() {
		return value;
	}
	
	public double monitor() {
		return value.doubleValue();
	}
	
	@Override
	public void addContribution(ModelingElement elem, double impact){
		System.err.println("WARNING : Add contribution to a resource is unnecessary");
	}

}
