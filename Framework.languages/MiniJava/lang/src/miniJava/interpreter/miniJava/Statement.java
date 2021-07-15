package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.Node;

public interface Statement extends EObject, Node {
	void evaluateStatement(State state);
}
