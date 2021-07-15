package fr.gwendal_jouneaux.rob_lang.typing;

import com.google.common.base.Objects;
import fr.gwendal_jouneaux.rob_lang.robLANG.And;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet;
import fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.ComplexFunction;
import fr.gwendal_jouneaux.rob_lang.robLANG.Divide;
import fr.gwendal_jouneaux.rob_lang.robLANG.DoubleConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Equality;
import fr.gwendal_jouneaux.rob_lang.robLANG.Expression;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunCall;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp;
import fr.gwendal_jouneaux.rob_lang.robLANG.Greater;
import fr.gwendal_jouneaux.rob_lang.robLANG.GreaterEq;
import fr.gwendal_jouneaux.rob_lang.robLANG.InlineFunction;
import fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Less;
import fr.gwendal_jouneaux.rob_lang.robLANG.LessEq;
import fr.gwendal_jouneaux.rob_lang.robLANG.Minus;
import fr.gwendal_jouneaux.rob_lang.robLANG.Multiply;
import fr.gwendal_jouneaux.rob_lang.robLANG.Not;
import fr.gwendal_jouneaux.rob_lang.robLANG.Or;
import fr.gwendal_jouneaux.rob_lang.robLANG.Parameter;
import fr.gwendal_jouneaux.rob_lang.robLANG.Plus;
import fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression;
import fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Symbol;
import fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef;
import fr.gwendal_jouneaux.rob_lang.robLANG.Type;
import fr.gwendal_jouneaux.rob_lang.robLANG.Variable;
import fr.gwendal_jouneaux.rob_lang.typing.ArrayType;
import fr.gwendal_jouneaux.rob_lang.typing.BoolType;
import fr.gwendal_jouneaux.rob_lang.typing.DoubleType;
import fr.gwendal_jouneaux.rob_lang.typing.IntType;
import fr.gwendal_jouneaux.rob_lang.typing.RobLANGType;
import fr.gwendal_jouneaux.rob_lang.typing.StringType;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class RobLANGTypeComputer {
  public static final StringType STRING_TYPE = new StringType();
  
  public static final IntType INT_TYPE = new IntType();
  
  public static final BoolType BOOL_TYPE = new BoolType();
  
  public static final DoubleType DOUBLE_TYPE = new DoubleType();
  
  public static final DoubleType VOID_TYPE = new DoubleType();
  
  public boolean isStringType(final RobLANGType type) {
    return (type == RobLANGTypeComputer.STRING_TYPE);
  }
  
  public boolean isIntType(final RobLANGType type) {
    return (type == RobLANGTypeComputer.INT_TYPE);
  }
  
  public boolean isBoolType(final RobLANGType type) {
    return (type == RobLANGTypeComputer.BOOL_TYPE);
  }
  
  public boolean isDoubleType(final RobLANGType type) {
    return (type == RobLANGTypeComputer.DOUBLE_TYPE);
  }
  
  public boolean isArrayType(final RobLANGType type) {
    return (type instanceof ArrayType);
  }
  
  protected RobLANGType _typeFor(final Expression e) {
    RobLANGType _switchResult = null;
    boolean _matched = false;
    if (e instanceof StringConstant) {
      _matched=true;
      _switchResult = RobLANGTypeComputer.STRING_TYPE;
    }
    if (!_matched) {
      if (e instanceof IntConstant) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.INT_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof BoolConstant) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof DoubleConstant) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.DOUBLE_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Not) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Greater) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof GreaterEq) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Less) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof LessEq) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Equality) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof And) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      if (e instanceof Or) {
        _matched=true;
        _switchResult = RobLANGTypeComputer.BOOL_TYPE;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  protected RobLANGType _typeFor(final Plus e) {
    RobLANGType _xblockexpression = null;
    {
      final RobLANGType leftType = this.typeFor(e.getLeft());
      Expression _right = e.getRight();
      RobLANGType _typeFor = null;
      if (_right!=null) {
        _typeFor=this.typeFor(_right);
      }
      final RobLANGType rightType = _typeFor;
      RobLANGType _xifexpression = null;
      if ((this.isStringType(leftType) || this.isStringType(rightType))) {
        _xifexpression = RobLANGTypeComputer.STRING_TYPE;
      } else {
        RobLANGType _xifexpression_1 = null;
        if ((this.isDoubleType(leftType) || this.isDoubleType(rightType))) {
          _xifexpression_1 = RobLANGTypeComputer.DOUBLE_TYPE;
        } else {
          _xifexpression_1 = RobLANGTypeComputer.INT_TYPE;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected RobLANGType _typeFor(final Minus e) {
    RobLANGType _xblockexpression = null;
    {
      final RobLANGType leftType = this.typeFor(e.getLeft());
      Expression _right = e.getRight();
      RobLANGType _typeFor = null;
      if (_right!=null) {
        _typeFor=this.typeFor(_right);
      }
      final RobLANGType rightType = _typeFor;
      RobLANGType _xifexpression = null;
      if ((this.isDoubleType(leftType) || this.isDoubleType(rightType))) {
        _xifexpression = RobLANGTypeComputer.DOUBLE_TYPE;
      } else {
        _xifexpression = RobLANGTypeComputer.INT_TYPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected RobLANGType _typeFor(final Divide e) {
    RobLANGType _xblockexpression = null;
    {
      final RobLANGType leftType = this.typeFor(e.getLeft());
      Expression _right = e.getRight();
      RobLANGType _typeFor = null;
      if (_right!=null) {
        _typeFor=this.typeFor(_right);
      }
      final RobLANGType rightType = _typeFor;
      RobLANGType _xifexpression = null;
      if ((this.isDoubleType(leftType) || this.isDoubleType(rightType))) {
        _xifexpression = RobLANGTypeComputer.DOUBLE_TYPE;
      } else {
        _xifexpression = RobLANGTypeComputer.INT_TYPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected RobLANGType _typeFor(final Multiply e) {
    RobLANGType _xblockexpression = null;
    {
      final RobLANGType leftType = this.typeFor(e.getLeft());
      Expression _right = e.getRight();
      RobLANGType _typeFor = null;
      if (_right!=null) {
        _typeFor=this.typeFor(_right);
      }
      final RobLANGType rightType = _typeFor;
      RobLANGType _xifexpression = null;
      if ((this.isDoubleType(leftType) || this.isDoubleType(rightType))) {
        _xifexpression = RobLANGTypeComputer.DOUBLE_TYPE;
      } else {
        _xifexpression = RobLANGTypeComputer.INT_TYPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected RobLANGType _typeFor(final SymbolRef symbolRef) {
    Symbol _variable = symbolRef.getVariable();
    boolean _tripleEquals = (_variable == null);
    if (_tripleEquals) {
      return null;
    } else {
      return this.typeFor(symbolRef.getVariable());
    }
  }
  
  protected RobLANGType _typeFor(final Symbol symbol) {
    RobLANGType _switchResult = null;
    boolean _matched = false;
    if (symbol instanceof Variable) {
      _matched=true;
      _switchResult = this.typeFor(((Variable) symbol));
    }
    if (!_matched) {
      if (symbol instanceof Parameter) {
        _matched=true;
        _switchResult = this.typeFor(((Parameter) symbol));
      }
    }
    return _switchResult;
  }
  
  protected RobLANGType _typeFor(final PrintExpression eval) {
    Expression _expression = null;
    if (eval!=null) {
      _expression=eval.getExpression();
    }
    RobLANGType _typeFor = null;
    if (_expression!=null) {
      _typeFor=this.typeFor(_expression);
    }
    return _typeFor;
  }
  
  protected RobLANGType _typeFor(final Variable variable) {
    Expression _expression = null;
    if (variable!=null) {
      _expression=variable.getExpression();
    }
    RobLANGType _typeFor = null;
    if (_expression!=null) {
      _typeFor=this.typeFor(_expression);
    }
    return _typeFor;
  }
  
  protected RobLANGType _typeFor(final Type type) {
    final String basicType = type.getType().getName();
    final int dimension = type.getDimension();
    final boolean isArray = (dimension != 0);
    RobLANGType roblangType = ((RobLANGType) null);
    boolean _equals = Objects.equal(basicType, "String");
    if (_equals) {
      roblangType = RobLANGTypeComputer.STRING_TYPE;
    }
    boolean _equals_1 = Objects.equal(basicType, "bool");
    if (_equals_1) {
      roblangType = RobLANGTypeComputer.BOOL_TYPE;
    }
    boolean _equals_2 = Objects.equal(basicType, "int");
    if (_equals_2) {
      roblangType = RobLANGTypeComputer.INT_TYPE;
    }
    boolean _equals_3 = Objects.equal(basicType, "double");
    if (_equals_3) {
      roblangType = RobLANGTypeComputer.DOUBLE_TYPE;
    }
    boolean _equals_4 = Objects.equal(basicType, "void");
    if (_equals_4) {
      roblangType = RobLANGTypeComputer.VOID_TYPE;
    }
    if ((isArray && (roblangType != null))) {
      ArrayType _arrayType = new ArrayType(roblangType, dimension);
      roblangType = _arrayType;
    }
    return null;
  }
  
  protected RobLANGType _typeFor(final Parameter parameter) {
    return this.typeFor(parameter.getType());
  }
  
  protected RobLANGType _typeFor(final ComplexFunction function) {
    return this.typeFor(function.getType());
  }
  
  protected RobLANGType _typeFor(final InlineFunction function) {
    return this.typeFor(function.getType());
  }
  
  protected RobLANGType _typeFor(final FunCall call) {
    return this.typeFor(call.getFunction());
  }
  
  protected RobLANGType _typeFor(final FunParamExp param) {
    return this.typeFor(param.getExpr());
  }
  
  protected RobLANGType _typeFor(final FunParamCapture param) {
    return this.typeFor(param.getVariable());
  }
  
  protected RobLANGType _typeFor(final ArrayGet arrayGet) {
    RobLANGType _typeFor = this.typeFor(arrayGet.getArray());
    final ArrayType arrayType = ((ArrayType) _typeFor);
    return arrayType.afterAccess();
  }
  
  public RobLANGType typeFor(final EObject arrayGet) {
    if (arrayGet instanceof ArrayGet) {
      return _typeFor((ArrayGet)arrayGet);
    } else if (arrayGet instanceof Divide) {
      return _typeFor((Divide)arrayGet);
    } else if (arrayGet instanceof FunCall) {
      return _typeFor((FunCall)arrayGet);
    } else if (arrayGet instanceof Minus) {
      return _typeFor((Minus)arrayGet);
    } else if (arrayGet instanceof Multiply) {
      return _typeFor((Multiply)arrayGet);
    } else if (arrayGet instanceof Plus) {
      return _typeFor((Plus)arrayGet);
    } else if (arrayGet instanceof SymbolRef) {
      return _typeFor((SymbolRef)arrayGet);
    } else if (arrayGet instanceof ComplexFunction) {
      return _typeFor((ComplexFunction)arrayGet);
    } else if (arrayGet instanceof Expression) {
      return _typeFor((Expression)arrayGet);
    } else if (arrayGet instanceof FunParamCapture) {
      return _typeFor((FunParamCapture)arrayGet);
    } else if (arrayGet instanceof FunParamExp) {
      return _typeFor((FunParamExp)arrayGet);
    } else if (arrayGet instanceof InlineFunction) {
      return _typeFor((InlineFunction)arrayGet);
    } else if (arrayGet instanceof Parameter) {
      return _typeFor((Parameter)arrayGet);
    } else if (arrayGet instanceof PrintExpression) {
      return _typeFor((PrintExpression)arrayGet);
    } else if (arrayGet instanceof Variable) {
      return _typeFor((Variable)arrayGet);
    } else if (arrayGet instanceof Symbol) {
      return _typeFor((Symbol)arrayGet);
    } else if (arrayGet instanceof Type) {
      return _typeFor((Type)arrayGet);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(arrayGet).toString());
    }
  }
}
