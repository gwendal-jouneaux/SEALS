/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd#getValueOrIndex <em>Value Or Index</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd#getIndexedValue <em>Indexed Value</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getArrayAdd()
 * @model
 * @generated
 */
public interface ArrayAdd extends ArrayStatement
{
  /**
   * Returns the value of the '<em><b>Value Or Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Or Index</em>' containment reference.
   * @see #setValueOrIndex(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getArrayAdd_ValueOrIndex()
   * @model containment="true"
   * @generated
   */
  Expression getValueOrIndex();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd#getValueOrIndex <em>Value Or Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Or Index</em>' containment reference.
   * @see #getValueOrIndex()
   * @generated
   */
  void setValueOrIndex(Expression value);

  /**
   * Returns the value of the '<em><b>Indexed Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indexed Value</em>' containment reference.
   * @see #setIndexedValue(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getArrayAdd_IndexedValue()
   * @model containment="true"
   * @generated
   */
  Expression getIndexedValue();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd#getIndexedValue <em>Indexed Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indexed Value</em>' containment reference.
   * @see #getIndexedValue()
   * @generated
   */
  void setIndexedValue(Expression value);

} // ArrayAdd
