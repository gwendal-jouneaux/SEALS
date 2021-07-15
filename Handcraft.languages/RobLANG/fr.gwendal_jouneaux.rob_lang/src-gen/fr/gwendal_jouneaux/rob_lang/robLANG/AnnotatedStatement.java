/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotated Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getProperty <em>Property</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getHigherBound <em>Higher Bound</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getAnnotatedStatement()
 * @model
 * @generated
 */
public interface AnnotatedStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' attribute.
   * The literals are from the enumeration {@link fr.gwendal_jouneaux.rob_lang.robLANG.AdaptationProperty}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' attribute.
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.AdaptationProperty
   * @see #setProperty(AdaptationProperty)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getAnnotatedStatement_Property()
   * @model
   * @generated
   */
  AdaptationProperty getProperty();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getProperty <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' attribute.
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.AdaptationProperty
   * @see #getProperty()
   * @generated
   */
  void setProperty(AdaptationProperty value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' containment reference.
   * @see #setLowerBound(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getAnnotatedStatement_LowerBound()
   * @model containment="true"
   * @generated
   */
  Expression getLowerBound();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getLowerBound <em>Lower Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' containment reference.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(Expression value);

  /**
   * Returns the value of the '<em><b>Higher Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Higher Bound</em>' containment reference.
   * @see #setHigherBound(Expression)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getAnnotatedStatement_HigherBound()
   * @model containment="true"
   * @generated
   */
  Expression getHigherBound();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getHigherBound <em>Higher Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Higher Bound</em>' containment reference.
   * @see #getHigherBound()
   * @generated
   */
  void setHigherBound(Expression value);

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference.
   * @see #setStatement(SimpleStatement)
   * @see fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage#getAnnotatedStatement_Statement()
   * @model containment="true"
   * @generated
   */
  SimpleStatement getStatement();

  /**
   * Sets the value of the '{@link fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement#getStatement <em>Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statement</em>' containment reference.
   * @see #getStatement()
   * @generated
   */
  void setStatement(SimpleStatement value);

} // AnnotatedStatement