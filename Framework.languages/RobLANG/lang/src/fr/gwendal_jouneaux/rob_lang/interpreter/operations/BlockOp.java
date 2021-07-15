package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.Conversions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Block;

@Operationalize(node = Block.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class BlockOp extends Operation<Block> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Block e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object res = ((Object) null);
	    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(e.getStatements(), Object.class)).length); i++) {
	      res = e.getStatements().get(i).accept(vis, context);
	    }
	    return res;
	}

}