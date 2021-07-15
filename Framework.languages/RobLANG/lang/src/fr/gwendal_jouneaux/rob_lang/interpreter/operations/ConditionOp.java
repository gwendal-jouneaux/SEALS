package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Block;
import fr.gwendal_jouneaux.rob_lang.robLANG.Condition;

@Operationalize(node = Condition.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ConditionOp extends Operation<Condition> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Condition e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _interpretAdapt = e.getExpression().accept(vis, context);
	    Boolean cond = ((Boolean) _interpretAdapt);
	    if ((cond).booleanValue()) {
	      return e.getIfz().accept(vis, context);
	    } else {
	      Block _elsez = e.getElsez();
	      boolean _tripleNotEquals = (_elsez != null);
	      if (_tripleNotEquals) {
	        return e.getElsez().accept(vis, context);
	      }
	    }
	    return null;
	}

}