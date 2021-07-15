/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Length</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength#getArray <em>Array</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getArrayLength()
 * @model
 * @generated
 */
public interface ArrayLength extends ArrayExpression
{
  /**
   * Returns the value of the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array</em>' containment reference.
   * @see #setArray(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getArrayLength_Array()
   * @model containment="true"
   * @generated
   */
  Expression getArray();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength#getArray <em>Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array</em>' containment reference.
   * @see #getArray()
   * @generated
   */
  void setArray(Expression value);

} // ArrayLength