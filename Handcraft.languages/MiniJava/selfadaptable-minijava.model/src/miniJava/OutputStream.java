/**
 */
package miniJava;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link miniJava.OutputStream#getStream <em>Stream</em>}</li>
 * </ul>
 *
 * @see miniJava.MiniJavaPackage#getOutputStream()
 * @model annotation="aspect"
 * @generated
 */
public interface OutputStream extends EObject {
	/**
	 * Returns the value of the '<em><b>Stream</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stream</em>' attribute list.
	 * @see miniJava.MiniJavaPackage#getOutputStream_Stream()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getStream();

} // OutputStream
