package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.Node;

public interface NamedElement extends EObject, Node  {
	String getName();

	void setName(String value);
}
