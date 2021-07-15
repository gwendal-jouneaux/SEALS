package fr.gjouneau.savm.framework.decision.model.visitor;

import fr.gjouneau.savm.framework.decision.model.Goal;
import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.decision.model.Softgoal;
import fr.gjouneau.savm.framework.decision.model.Task;
import fr.gjouneau.savm.framework.decision.model.Variable;

public interface IGoalVisitor<T> {
	
	public T visitGoal(Goal goal);
	public T visitSoftGoal(Softgoal softgoal);
	public T visitTask(Task task);
	public T visitVariable(Variable variable);
	public T visitResource(Resource resource);
}
