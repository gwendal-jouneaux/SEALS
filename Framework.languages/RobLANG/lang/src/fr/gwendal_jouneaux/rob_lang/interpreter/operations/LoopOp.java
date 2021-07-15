package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.Exceptions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.LoopBreak;
import fr.gwendal_jouneaux.rob_lang.robLANG.Loop;

@Operationalize(node = Loop.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class LoopOp extends Operation<Loop> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Loop e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object last = ((Object) null);
	    try {
	      while ((((Boolean) e.getExpression().accept(vis, context))).booleanValue()) {
	        last = e.getBody().accept(vis, context);
	      }
	    } catch (final Throwable _t) {
	      if (_t instanceof LoopBreak) {
	        last = ((Object) null);
	      } else {
	        throw Exceptions.sneakyThrow(_t);
	      }
	    }
	    return last;
	}

}