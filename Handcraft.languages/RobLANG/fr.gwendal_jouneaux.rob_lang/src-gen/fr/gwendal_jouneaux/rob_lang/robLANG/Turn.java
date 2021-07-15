/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Turn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.Turn#getAngle <em>Angle</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getTurn()
 * @model
 * @generated
 */
public interface Turn extends Effector
{
  /**
   * Returns the value of the '<em><b>Angle</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Angle</em>' containment reference.
   * @see #setAngle(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getTurn_Angle()
   * @model containment="true"
   * @generated
   */
  Expression getAngle();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.Turn#getAngle <em>Angle</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Angle</em>' containment reference.
   * @see #getAngle()
   * @generated
   */
  void setAngle(Expression value);

} // Turn