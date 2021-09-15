package miniJava.interpreter.miniJava;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.Node;

public interface Program extends EObject, Node {
	String getName();

	void setName(String value);

	EList<Import> getImports();

	EList<TypeDeclaration> getClasses();

	State getState();

	void setState(State value);

	void initialize(EList args);

	Method findMain();
}
