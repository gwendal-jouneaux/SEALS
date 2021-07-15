package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.Exceptions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.LoopBreak;
import fr.gwendal_jouneaux.rob_lang.robLANG.Break;

@Operationalize(node = Break.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class BreakOp extends Operation<Break> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Break e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		try {
		      throw new LoopBreak();
		    } catch (Throwable _e) {
		      throw Exceptions.sneakyThrow(_e);
		    }
	}

}