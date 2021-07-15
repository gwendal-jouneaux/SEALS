/**
 * generated by Xtext 2.22.0
 */
package fr.gwendal_jouneaux.rob_lang.robLANG.impl;

import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd;
import fr.gwendal_jouneaux.rob_lang.robLANG.Expression;
import fr.gwendal_jouneaux.rob_lang.robLANG.RobLANGPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Add</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.impl.ArrayAddImpl#getValueOrIndex <em>Value Or Index</em>}</li>
 *   <li>{@link fr.gwendal_jouneaux.rob_lang.robLANG.impl.ArrayAddImpl#getIndexedValue <em>Indexed Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayAddImpl extends ArrayStatementImpl implements ArrayAdd
{
  /**
   * The cached value of the '{@link #getValueOrIndex() <em>Value Or Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueOrIndex()
   * @generated
   * @ordered
   */
  protected Expression valueOrIndex;

  /**
   * The cached value of the '{@link #getIndexedValue() <em>Indexed Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndexedValue()
   * @generated
   * @ordered
   */
  protected Expression indexedValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayAddImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RobLANGPackage.Literals.ARRAY_ADD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValueOrIndex()
  {
    return valueOrIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueOrIndex(Expression newValueOrIndex, NotificationChain msgs)
  {
    Expression oldValueOrIndex = valueOrIndex;
    valueOrIndex = newValueOrIndex;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX, oldValueOrIndex, newValueOrIndex);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValueOrIndex(Expression newValueOrIndex)
  {
    if (newValueOrIndex != valueOrIndex)
    {
      NotificationChain msgs = null;
      if (valueOrIndex != null)
        msgs = ((InternalEObject)valueOrIndex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX, null, msgs);
      if (newValueOrIndex != null)
        msgs = ((InternalEObject)newValueOrIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX, null, msgs);
      msgs = basicSetValueOrIndex(newValueOrIndex, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX, newValueOrIndex, newValueOrIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getIndexedValue()
  {
    return indexedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndexedValue(Expression newIndexedValue, NotificationChain msgs)
  {
    Expression oldIndexedValue = indexedValue;
    indexedValue = newIndexedValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobLANGPackage.ARRAY_ADD__INDEXED_VALUE, oldIndexedValue, newIndexedValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setIndexedValue(Expression newIndexedValue)
  {
    if (newIndexedValue != indexedValue)
    {
      NotificationChain msgs = null;
      if (indexedValue != null)
        msgs = ((InternalEObject)indexedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobLANGPackage.ARRAY_ADD__INDEXED_VALUE, null, msgs);
      if (newIndexedValue != null)
        msgs = ((InternalEObject)newIndexedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobLANGPackage.ARRAY_ADD__INDEXED_VALUE, null, msgs);
      msgs = basicSetIndexedValue(newIndexedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RobLANGPackage.ARRAY_ADD__INDEXED_VALUE, newIndexedValue, newIndexedValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX:
        return basicSetValueOrIndex(null, msgs);
      case RobLANGPackage.ARRAY_ADD__INDEXED_VALUE:
        return basicSetIndexedValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX:
        return getValueOrIndex();
      case RobLANGPackage.ARRAY_ADD__INDEXED_VALUE:
        return getIndexedValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX:
        setValueOrIndex((Expression)newValue);
        return;
      case RobLANGPackage.ARRAY_ADD__INDEXED_VALUE:
        setIndexedValue((Expression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX:
        setValueOrIndex((Expression)null);
        return;
      case RobLANGPackage.ARRAY_ADD__INDEXED_VALUE:
        setIndexedValue((Expression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RobLANGPackage.ARRAY_ADD__VALUE_OR_INDEX:
        return valueOrIndex != null;
      case RobLANGPackage.ARRAY_ADD__INDEXED_VALUE:
        return indexedValue != null;
    }
    return super.eIsSet(featureID);
  }

} //ArrayAddImpl