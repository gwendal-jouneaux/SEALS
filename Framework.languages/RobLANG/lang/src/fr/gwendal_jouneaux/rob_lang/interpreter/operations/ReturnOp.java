package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.Exceptions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.FunctionReturn;
import fr.gwendal_jouneaux.rob_lang.robLANG.Return;

@Operationalize(node = Return.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class ReturnOp extends Operation<Return> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Return e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		try {
		      Object _interpretAdapt = e.getExpression().accept(vis, context);
		      throw new FunctionReturn(_interpretAdapt);
		    } catch (Throwable _e) {
		      throw Exceptions.sneakyThrow(_e);
		    }
	}

}