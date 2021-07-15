package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.Node;

public interface Import extends EObject, Node {
	String getImportedNamespace();

	void setImportedNamespace(String value);
}
