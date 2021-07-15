/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getPrintExpression()
 * @model
 * @generated
 */
public interface PrintExpression extends Statement
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getPrintExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // PrintExpression
