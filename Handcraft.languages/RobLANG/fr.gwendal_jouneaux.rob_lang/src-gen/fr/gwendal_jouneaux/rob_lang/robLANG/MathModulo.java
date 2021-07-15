/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Math Modulo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo#getLhs <em>Lhs</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getMathModulo()
 * @model
 * @generated
 */
public interface MathModulo extends MathExpression
{
  /**
   * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lhs</em>' containment reference.
   * @see #setLhs(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getMathModulo_Lhs()
   * @model containment="true"
   * @generated
   */
  Expression getLhs();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo#getLhs <em>Lhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lhs</em>' containment reference.
   * @see #getLhs()
   * @generated
   */
  void setLhs(Expression value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getMathModulo_Rhs()
   * @model containment="true"
   * @generated
   */
  Expression getRhs();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expression value);

} // MathModulo