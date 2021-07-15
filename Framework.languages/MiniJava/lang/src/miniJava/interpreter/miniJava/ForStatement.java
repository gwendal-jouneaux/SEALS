package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import miniJava.interpreter.miniJava.interfaces.ForInterface;

public interface ForStatement extends EObject, Statement, AdaptableNode<ForInterface> {
	Assignment getDeclaration();

	void setDeclaration(Assignment value);

	Expression getCondition();

	void setCondition(Expression value);

	Assignment getProgression();

	void setProgression(Assignment value);

	Block getBlock();

	void setBlock(Block value);

	void evaluateStatement(State state);
}
