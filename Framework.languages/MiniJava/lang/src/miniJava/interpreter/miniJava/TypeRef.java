package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

import fr.gjouneau.savm.framework.lang.semantics.Node;

public interface TypeRef extends EObject, Node  {
	boolean compare(TypeRef other);
}
