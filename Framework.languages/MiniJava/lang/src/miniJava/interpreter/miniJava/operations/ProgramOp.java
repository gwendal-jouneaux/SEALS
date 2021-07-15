package miniJava.interpreter.miniJava.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.Program;
import miniJava.interpreter.miniJava.State;

@Operationalize(node = Program.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class ProgramOp extends Operation<Program>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Program node, Object execCtx) {
		Context result;
		Method main = ((Method) (((Program) (node)).findMain()));
		result = (Context) ((Block) (main.getBody())).accept(vis, (State) (node.getState()));
		return result;
	}
}
