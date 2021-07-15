/**
 * generated by Xtext 2.10.0
 */
package org.tetrabox.minijava.xtext.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import miniJava.Assignee;
import miniJava.Assignment;
import miniJava.Block;
import miniJava.Field;
import miniJava.FieldAccess;
import miniJava.ForStatement;
import miniJava.Member;
import miniJava.Method;
import miniJava.MethodCall;
import miniJava.MiniJavaPackage;
import miniJava.Statement;
import miniJava.TypeDeclaration;
import miniJava.VariableDeclaration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.tetrabox.minijava.xtext.MiniJavaModelUtil;
import org.tetrabox.minijava.xtext.scoping.AbstractMiniJavaScopeProvider;
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeComputer;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class MiniJavaScopeProvider extends AbstractMiniJavaScopeProvider {
  private final MiniJavaPackage epackage = MiniJavaPackage.eINSTANCE;
  
  @Inject
  @Extension
  private MiniJavaModelUtil _miniJavaModelUtil;
  
  @Inject
  @Extension
  private MiniJavaTypeComputer _miniJavaTypeComputer;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    EReference _symbolRef_Symbol = this.epackage.getSymbolRef_Symbol();
    boolean _equals = Objects.equal(reference, _symbolRef_Symbol);
    if (_equals) {
      return this.scopeForSymbolRef(context);
    } else {
      if ((context instanceof MethodCall)) {
        return this.scopeForMethodCall(((MethodCall)context));
      } else {
        if ((context instanceof FieldAccess)) {
          return this.scopeForFieldAccess(((FieldAccess)context));
        }
      }
    }
    return super.getScope(context, reference);
  }
  
  protected IScope scopeForSymbolRef(final EObject context) {
    final EObject container = context.eContainer();
    IScope _switchResult = null;
    boolean _matched = false;
    if (container instanceof Method) {
      _matched=true;
      _switchResult = Scopes.scopeFor(((Method)container).getParams());
    }
    if (!_matched) {
      if (container instanceof Block) {
        _matched=true;
        final Function1<Statement, Boolean> _function = (Statement it) -> {
          return Boolean.valueOf((!Objects.equal(it, context)));
        };
        final Function1<Assignment, Assignee> _function_1 = (Assignment it) -> {
          return it.getAssignee();
        };
        _switchResult = Scopes.scopeFor(
          Iterables.<VariableDeclaration>filter(IterableExtensions.<Assignment, Assignee>map(Iterables.<Assignment>filter(IterableExtensions.<Statement>takeWhile(((Block)container).getStatements(), _function), Assignment.class), _function_1), 
            VariableDeclaration.class), 
          this.scopeForSymbolRef(container));
      }
    }
    if (!_matched) {
      if (container instanceof ForStatement) {
        _matched=true;
        Assignee _assignee = ((ForStatement)container).getDeclaration().getAssignee();
        _switchResult = Scopes.scopeFor(
          Collections.<EObject>unmodifiableList(CollectionLiterals.<EObject>newArrayList(_assignee)), 
          this.scopeForSymbolRef(container));
      }
    }
    if (!_matched) {
      _switchResult = this.scopeForSymbolRef(container);
    }
    return _switchResult;
  }
  
  public IScope scopeForFieldAccess(final FieldAccess sel) {
    final TypeDeclaration type = this._miniJavaTypeComputer.typeFor(sel.getReceiver());
    if (((type == null) || this._miniJavaTypeComputer.isPrimitive(type))) {
      return IScope.NULLSCOPE;
    }
    final Function1<Member, Boolean> _function = (Member it) -> {
      return Boolean.valueOf((it instanceof Method));
    };
    final Map<Boolean, List<Member>> grouped = IterableExtensions.<Boolean, Member>groupBy(this._miniJavaModelUtil.classHierarchyMembers(type), _function);
    List<Member> _elvis = null;
    List<Member> _get = grouped.get(Boolean.valueOf(true));
    if (_get != null) {
      _elvis = _get;
    } else {
      List<Member> _emptyList = CollectionLiterals.<Member>emptyList();
      _elvis = _emptyList;
    }
    final List<Member> inheritedMethods = _elvis;
    List<Member> _elvis_1 = null;
    List<Member> _get_1 = grouped.get(Boolean.valueOf(false));
    if (_get_1 != null) {
      _elvis_1 = _get_1;
    } else {
      List<Member> _emptyList_1 = CollectionLiterals.<Member>emptyList();
      _elvis_1 = _emptyList_1;
    }
    final List<Member> inheritedFields = _elvis_1;
    Iterable<Field> _fields = this._miniJavaModelUtil.fields(type);
    Iterable<Method> _methods = this._miniJavaModelUtil.methods(type);
    Iterable<Member> _plus = Iterables.<Member>concat(_fields, _methods);
    Iterable<Member> _plus_1 = Iterables.<Member>concat(inheritedFields, inheritedMethods);
    return Scopes.scopeFor(_plus, 
      Scopes.scopeFor(_plus_1));
  }
  
  public IScope scopeForMethodCall(final MethodCall sel) {
    final TypeDeclaration type = this._miniJavaTypeComputer.typeFor(sel.getReceiver());
    if (((type == null) || this._miniJavaTypeComputer.isPrimitive(type))) {
      return IScope.NULLSCOPE;
    }
    final Function1<Member, Boolean> _function = (Member it) -> {
      return Boolean.valueOf((it instanceof Method));
    };
    final Map<Boolean, List<Member>> grouped = IterableExtensions.<Boolean, Member>groupBy(this._miniJavaModelUtil.classHierarchyMembers(type), _function);
    List<Member> _elvis = null;
    List<Member> _get = grouped.get(Boolean.valueOf(true));
    if (_get != null) {
      _elvis = _get;
    } else {
      List<Member> _emptyList = CollectionLiterals.<Member>emptyList();
      _elvis = _emptyList;
    }
    final List<Member> inheritedMethods = _elvis;
    List<Member> _elvis_1 = null;
    List<Member> _get_1 = grouped.get(Boolean.valueOf(false));
    if (_get_1 != null) {
      _elvis_1 = _get_1;
    } else {
      List<Member> _emptyList_1 = CollectionLiterals.<Member>emptyList();
      _elvis_1 = _emptyList_1;
    }
    final List<Member> inheritedFields = _elvis_1;
    Iterable<Method> _methods = this._miniJavaModelUtil.methods(type);
    Iterable<Field> _fields = this._miniJavaModelUtil.fields(type);
    Iterable<Member> _plus = Iterables.<Member>concat(_methods, _fields);
    Iterable<Member> _plus_1 = Iterables.<Member>concat(inheritedMethods, inheritedFields);
    return Scopes.scopeFor(_plus, 
      Scopes.scopeFor(_plus_1));
  }
}