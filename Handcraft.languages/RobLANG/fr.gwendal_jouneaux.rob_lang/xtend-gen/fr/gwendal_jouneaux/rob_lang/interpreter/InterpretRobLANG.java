package fr.gwendal_jouneaux.rob_lang.interpreter;

import com.google.common.base.Objects;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.FunctionReturn;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.LoopBreak;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.And;
import fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedStatement;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayNew;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArrayRemove;
import fr.gwendal_jouneaux.rob_lang.robLANG.ArraySet;
import fr.gwendal_jouneaux.rob_lang.robLANG.Assignment;
import fr.gwendal_jouneaux.rob_lang.robLANG.Block;
import fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Break;
import fr.gwendal_jouneaux.rob_lang.robLANG.ComplexFunction;
import fr.gwendal_jouneaux.rob_lang.robLANG.Condition;
import fr.gwendal_jouneaux.rob_lang.robLANG.Divide;
import fr.gwendal_jouneaux.rob_lang.robLANG.DoubleConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Equality;
import fr.gwendal_jouneaux.rob_lang.robLANG.Expression;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunCall;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunDefinition;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParam;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp;
import fr.gwendal_jouneaux.rob_lang.robLANG.Greater;
import fr.gwendal_jouneaux.rob_lang.robLANG.GreaterEq;
import fr.gwendal_jouneaux.rob_lang.robLANG.Inequality;
import fr.gwendal_jouneaux.rob_lang.robLANG.InlineFunction;
import fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.Less;
import fr.gwendal_jouneaux.rob_lang.robLANG.LessEq;
import fr.gwendal_jouneaux.rob_lang.robLANG.Loop;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathAbs;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathCos;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathPow;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathSin;
import fr.gwendal_jouneaux.rob_lang.robLANG.MathSqrt;
import fr.gwendal_jouneaux.rob_lang.robLANG.Minus;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward;
import fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward;
import fr.gwendal_jouneaux.rob_lang.robLANG.Multiply;
import fr.gwendal_jouneaux.rob_lang.robLANG.Not;
import fr.gwendal_jouneaux.rob_lang.robLANG.Or;
import fr.gwendal_jouneaux.rob_lang.robLANG.Plus;
import fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression;
import fr.gwendal_jouneaux.rob_lang.robLANG.Return;
import fr.gwendal_jouneaux.rob_lang.robLANG.Robot;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseBattery;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseCompass;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseDistance;
import fr.gwendal_jouneaux.rob_lang.robLANG.SensePosition;
import fr.gwendal_jouneaux.rob_lang.robLANG.SenseTime;
import fr.gwendal_jouneaux.rob_lang.robLANG.SetNominalSpeed;
import fr.gwendal_jouneaux.rob_lang.robLANG.Statement;
import fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant;
import fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft;
import fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight;
import fr.gwendal_jouneaux.rob_lang.robLANG.Variable;
import fr.gwendal_jouneaux.rob_lang.robLANG.impl.RobLANGFactoryImpl;
import fr.gwendal_jouneaux.rob_lang.typing.RobLANGTypeComputer;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class InterpretRobLANG {
  private final RobLANGTypeComputer typer = new RobLANGTypeComputer();
  
  private static InterpretRobLANG instance = null;
  
  private InterpretRobLANG() {
  }
  
  public static InterpretRobLANG INSTANCE() {
    return new InterpretRobLANG();
  }
  
  public Object _interpret(final IntConstant e, final ContextRobLANG context) {
    return Integer.valueOf(e.getValue());
  }
  
  public Object _interpret(final BoolConstant e, final ContextRobLANG context) {
    return Boolean.valueOf(Boolean.parseBoolean(e.getValue()));
  }
  
  public Object _interpret(final StringConstant e, final ContextRobLANG context) {
    return e.getValue();
  }
  
  public Object _interpret(final DoubleConstant e, final ContextRobLANG context) {
    return Double.valueOf(e.getValue());
  }
  
  public Object _interpret(final Multiply e, final ContextRobLANG context) {
    boolean _isDoubleType = this.typer.isDoubleType(this.typer.typeFor(e));
    if (_isDoubleType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      return Double.valueOf(DoubleExtensions.operator_multiply(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() * (((Integer) _interpretAdapt_3)).intValue()));
    }
  }
  
  public Object _interpret(final Divide e, final ContextRobLANG context) {
    boolean _isDoubleType = this.typer.isDoubleType(this.typer.typeFor(e));
    if (_isDoubleType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      return Double.valueOf(DoubleExtensions.operator_divide(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() / (((Integer) _interpretAdapt_3)).intValue()));
    }
  }
  
  public Object _interpret(final Minus e, final ContextRobLANG context) {
    boolean _isDoubleType = this.typer.isDoubleType(this.typer.typeFor(e));
    if (_isDoubleType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      return Double.valueOf(DoubleExtensions.operator_minus(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() - (((Integer) _interpretAdapt_3)).intValue()));
    }
  }
  
  public Object _interpret(final Plus e, final ContextRobLANG context) {
    if ((this.typer.isStringType(this.typer.typeFor(e.getLeft())) || this.typer.isStringType(this.typer.typeFor(e.getRight())))) {
      String _string = this.interpretAdapt(e.getLeft(), context).toString();
      String _string_1 = this.interpretAdapt(e.getRight(), context).toString();
      return (_string + _string_1);
    } else {
      boolean _isDoubleType = this.typer.isDoubleType(this.typer.typeFor(e));
      if (_isDoubleType) {
        Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
        Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
        return Double.valueOf(DoubleExtensions.operator_plus(((Double) _interpretAdapt), ((Double) _interpretAdapt_1)));
      } else {
        Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
        Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
        return Integer.valueOf(((((Integer) _interpretAdapt_2)).intValue() + (((Integer) _interpretAdapt_3)).intValue()));
      }
    }
  }
  
  public Object _interpret(final Not e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    return Boolean.valueOf((!(((Boolean) _interpretAdapt)).booleanValue()));
  }
  
  public Object _interpret(final And e, final ContextRobLANG context) {
    return Boolean.valueOf(((((Boolean) this.interpretAdapt(e.getLeft(), context))).booleanValue() && (((Boolean) this.interpretAdapt(e.getRight(), context))).booleanValue()));
  }
  
  public Object _interpret(final Or e, final ContextRobLANG context) {
    return Boolean.valueOf(((((Boolean) this.interpretAdapt(e.getLeft(), context))).booleanValue() || (((Boolean) this.interpretAdapt(e.getRight(), context))).booleanValue()));
  }
  
  public Object _interpret(final Equality e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
    return Boolean.valueOf(Objects.equal(_interpretAdapt, _interpretAdapt_1));
  }
  
  public Object _interpret(final Inequality e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
    return Boolean.valueOf((!Objects.equal(_interpretAdapt, _interpretAdapt_1)));
  }
  
  public Object _interpret(final GreaterEq e, final ContextRobLANG context) {
    boolean _isStringType = this.typer.isStringType(this.typer.typeFor(e.getLeft()));
    if (_isStringType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      final String left = ((String) _interpretAdapt);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      final String right = ((String) _interpretAdapt_1);
      return Boolean.valueOf((left.compareTo(right) >= 0));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      final Number left_1 = ((Number) _interpretAdapt_2);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      final Number right_1 = ((Number) _interpretAdapt_3);
      double _doubleValue = left_1.doubleValue();
      double _doubleValue_1 = right_1.doubleValue();
      return Boolean.valueOf((_doubleValue >= _doubleValue_1));
    }
  }
  
  public Object _interpret(final Greater e, final ContextRobLANG context) {
    boolean _isStringType = this.typer.isStringType(this.typer.typeFor(e.getLeft()));
    if (_isStringType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      final String left = ((String) _interpretAdapt);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      final String right = ((String) _interpretAdapt_1);
      return Boolean.valueOf((left.compareTo(right) > 0));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      final Number left_1 = ((Number) _interpretAdapt_2);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      final Number right_1 = ((Number) _interpretAdapt_3);
      double _doubleValue = left_1.doubleValue();
      double _doubleValue_1 = right_1.doubleValue();
      return Boolean.valueOf((_doubleValue > _doubleValue_1));
    }
  }
  
  public Object _interpret(final LessEq e, final ContextRobLANG context) {
    boolean _isStringType = this.typer.isStringType(this.typer.typeFor(e.getLeft()));
    if (_isStringType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      final String left = ((String) _interpretAdapt);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      final String right = ((String) _interpretAdapt_1);
      return Boolean.valueOf((left.compareTo(right) <= 0));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      final Number left_1 = ((Number) _interpretAdapt_2);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      final Number right_1 = ((Number) _interpretAdapt_3);
      double _doubleValue = left_1.doubleValue();
      double _doubleValue_1 = right_1.doubleValue();
      return Boolean.valueOf((_doubleValue <= _doubleValue_1));
    }
  }
  
  public Object _interpret(final Less e, final ContextRobLANG context) {
    boolean _isStringType = this.typer.isStringType(this.typer.typeFor(e.getLeft()));
    if (_isStringType) {
      Object _interpretAdapt = this.interpretAdapt(e.getLeft(), context);
      final String left = ((String) _interpretAdapt);
      Object _interpretAdapt_1 = this.interpretAdapt(e.getRight(), context);
      final String right = ((String) _interpretAdapt_1);
      return Boolean.valueOf((left.compareTo(right) < 0));
    } else {
      Object _interpretAdapt_2 = this.interpretAdapt(e.getLeft(), context);
      final Number left_1 = ((Number) _interpretAdapt_2);
      Object _interpretAdapt_3 = this.interpretAdapt(e.getRight(), context);
      final Number right_1 = ((Number) _interpretAdapt_3);
      double _doubleValue = left_1.doubleValue();
      double _doubleValue_1 = right_1.doubleValue();
      return Boolean.valueOf((_doubleValue < _doubleValue_1));
    }
  }
  
  public Object _interpret(final SymbolRef e, final ContextRobLANG context) {
    Object _xblockexpression = null;
    {
      boolean _isStringType = this.typer.isStringType(this.typer.typeFor(e.getVariable()));
      if (_isStringType) {
        Object _get = context.get(e.getVariable().getName());
        return ((String) _get);
      }
      boolean _isIntType = this.typer.isIntType(this.typer.typeFor(e.getVariable()));
      if (_isIntType) {
        Object _get_1 = context.get(e.getVariable().getName());
        return ((Integer) _get_1);
      }
      boolean _isBoolType = this.typer.isBoolType(this.typer.typeFor(e.getVariable()));
      if (_isBoolType) {
        Object _get_2 = context.get(e.getVariable().getName());
        return ((Boolean) _get_2);
      }
      boolean _isDoubleType = this.typer.isDoubleType(this.typer.typeFor(e.getVariable()));
      if (_isDoubleType) {
        Object _get_3 = context.get(e.getVariable().getName());
        return ((Double) _get_3);
      }
      boolean _isArrayType = this.typer.isArrayType(this.typer.typeFor(e.getVariable()));
      if (_isArrayType) {
        Object _get_4 = context.get(e.getVariable().getName());
        return ((RuntimeArray) _get_4);
      }
      _xblockexpression = context.get(e.getVariable().getName());
    }
    return _xblockexpression;
  }
  
  public Object _interpret(final FunCall e, final ContextRobLANG context) {
    final FunDefinition function = e.getFunction();
    HashMap<String, Object> params = new HashMap<String, Object>();
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(function.getVarNames(), Object.class)).length); i++) {
      params.put(function.getVarNames().get(i).getName(), this.interpretAdapt(e.getParams().get(i), context));
    }
    context.pushContext(params);
    Object res = ((Object) null);
    if ((function instanceof InlineFunction)) {
      res = this.interpretAdapt(((InlineFunction)function).getExpression(), context);
    }
    if ((function instanceof ComplexFunction)) {
      try {
        res = this.interpretAdapt(((ComplexFunction)function).getBody(), context);
      } catch (final Throwable _t) {
        if (_t instanceof FunctionReturn) {
          final FunctionReturn ret = (FunctionReturn)_t;
          res = ret.toReturn();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    HashMap<String, Object> captured = new HashMap<String, Object>();
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(e.getParams(), Object.class)).length); i++) {
      {
        final FunParam param = e.getParams().get(i);
        if ((param instanceof FunParamCapture)) {
          captured.put(((FunParamCapture)param).getVariable().getName(), context.get(function.getVarNames().get(i).getName()));
        }
      }
    }
    context.popContext();
    context.addAll(captured);
    return res;
  }
  
  public Object _interpret(final FunParamCapture e, final ContextRobLANG context) {
    return context.get(e.getVariable().getName());
  }
  
  public Object _interpret(final FunParamExp e, final ContextRobLANG context) {
    return this.interpretAdapt(e.getExpr(), context);
  }
  
  public Object _interpret(final Block e, final ContextRobLANG context) {
    Object res = ((Object) null);
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(e.getStatements(), Object.class)).length); i++) {
      res = this.interpretAdapt(e.getStatements().get(i), context);
    }
    return res;
  }
  
  public Object _interpret(final Break e, final ContextRobLANG context) {
    try {
      throw new LoopBreak();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object _interpret(final Return e, final ContextRobLANG context) {
    try {
      Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
      throw new FunctionReturn(_interpretAdapt);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object _interpret(final SenseTime e, final ContextRobLANG context) {
    return Double.valueOf(context.getTime());
  }
  
  public Object _interpret(final SenseBattery e, final ContextRobLANG context) {
    return Double.valueOf(context.getBattery());
  }
  
  public Object _interpret(final SensePosition e, final ContextRobLANG context) {
    final RuntimeArray array = new RuntimeArray(1);
    final double[] pos = context.getPosition();
    for (final double axis : pos) {
      array.add(Double.valueOf(axis));
    }
    return array;
  }
  
  public Object _interpret(final SenseDistance e, final ContextRobLANG context) {
    return Double.valueOf(context.getDistance(e.getSensorIndex()));
  }
  
  public Object _interpret(final SenseCompass e, final ContextRobLANG context) {
    return Double.valueOf(context.getCompass());
  }
  
  public Object _interpret(final Expression e, final ContextRobLANG context) {
    try {
      throw new Exception("AST Node not dispatched");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object _interpret(final Variable e, final ContextRobLANG context) {
    final Object value = this.interpretAdapt(e.getExpression(), context);
    context.put(e.getName(), value);
    return value;
  }
  
  public Object _interpret(final Assignment e, final ContextRobLANG context) {
    final Object value = this.interpretAdapt(e.getExpression(), context);
    context.put(e.getAssignee().getName(), value);
    return value;
  }
  
  public Object _interpret(final PrintExpression e, final ContextRobLANG context) {
    final Object value = this.interpretAdapt(e.getExpression(), context);
    context.getTime();
    InputOutput.<Object>println(value);
    return value;
  }
  
  public Object _interpret(final Condition e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    Boolean cond = ((Boolean) _interpretAdapt);
    if ((cond).booleanValue()) {
      return this.interpretAdapt(e.getIfz(), context);
    } else {
      Block _elsez = e.getElsez();
      boolean _tripleNotEquals = (_elsez != null);
      if (_tripleNotEquals) {
        return this.interpretAdapt(e.getElsez(), context);
      }
    }
    return null;
  }
  
  public Object _interpret(final Loop e, final ContextRobLANG context) {
    Object last = ((Object) null);
    try {
      while ((((Boolean) this.interpretAdapt(e.getExpression(), context))).booleanValue()) {
        last = this.interpretAdapt(e.getBody(), context);
      }
    } catch (final Throwable _t) {
      if (_t instanceof LoopBreak) {
        last = ((Object) null);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return last;
  }
  
  public Object _interpret(final MoveForward e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getDistance(), context);
    final Number dist = ((Number) _interpretAdapt);
    System.out.println("Forward");
    context.moveRobot(dist.doubleValue());
    return null;
  }
  
  public Object _interpret(final MoveBackward e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getDistance(), context);
    final Number dist = ((Number) _interpretAdapt);
    System.out.println("Backward");
    double _doubleValue = dist.doubleValue();
    double _minus = (-_doubleValue);
    context.moveRobot(_minus);
    return null;
  }
  
  public Object _interpret(final TurnLeft e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getAngle(), context);
    final Number angle = ((Number) _interpretAdapt);
    context.turnRobot(angle.doubleValue());
    return null;
  }
  
  public Object _interpret(final TurnRight e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getAngle(), context);
    final Number angle = ((Number) _interpretAdapt);
    double _doubleValue = angle.doubleValue();
    double _minus = (-_doubleValue);
    context.turnRobot(_minus);
    return null;
  }
  
  public Object _interpret(final SetNominalSpeed e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getSpeed(), context);
    final Number speed = ((Number) _interpretAdapt);
    context.setNominalSpeed(speed.doubleValue());
    return null;
  }
  
  public Object _interpret(final ArrayNew e, final ContextRobLANG context) {
    int _dimension = e.getDimension();
    return new RuntimeArray(_dimension);
  }
  
  public Object _interpret(final ArrayLength e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getArray(), context);
    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
    return Integer.valueOf(a.length());
  }
  
  public Object _interpret(final ArrayGet e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getArray(), context);
    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getIndex(), context);
    return a.get((((Integer) _interpretAdapt_1)).intValue());
  }
  
  public Object _interpret(final ArraySet e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getArray(), context);
    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getIndex(), context);
    a.set((((Integer) _interpretAdapt_1)).intValue(), this.interpretAdapt(e.getValue(), context));
    return null;
  }
  
  public Object _interpret(final ArrayAdd e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getArray(), context);
    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
    Expression _indexedValue = e.getIndexedValue();
    boolean _tripleEquals = (_indexedValue == null);
    if (_tripleEquals) {
      a.add(this.interpretAdapt(e.getValueOrIndex(), context));
    } else {
      Object _interpretAdapt_1 = this.interpretAdapt(e.getValueOrIndex(), context);
      a.add((((Integer) _interpretAdapt_1)).intValue(), this.interpretAdapt(e.getIndexedValue(), context));
    }
    return null;
  }
  
  public Object _interpret(final ArrayRemove e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getArray(), context);
    final RuntimeArray a = ((RuntimeArray) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getIndex(), context);
    a.remove((((Integer) _interpretAdapt_1)).intValue());
    return null;
  }
  
  public Object _interpret(final MathSqrt e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    final Number square = ((Number) _interpretAdapt);
    final double root = Math.sqrt(square.doubleValue());
    return ((Double) Double.valueOf(root));
  }
  
  public Object _interpret(final MathPow e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getValue(), context);
    final Number value = ((Number) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getExponant(), context);
    final Number exp = ((Number) _interpretAdapt_1);
    double _pow = Math.pow(value.doubleValue(), exp.doubleValue());
    return ((Double) Double.valueOf(_pow));
  }
  
  public Object _interpret(final MathSin e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    final Number value = ((Number) _interpretAdapt);
    final double sin = Math.sin(Math.toRadians(value.doubleValue()));
    return ((Double) Double.valueOf(sin));
  }
  
  public Object _interpret(final MathCos e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    final Number value = ((Number) _interpretAdapt);
    final double cos = Math.cos(Math.toRadians(value.doubleValue()));
    return ((Double) Double.valueOf(cos));
  }
  
  public Object _interpret(final MathAbs e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getExpression(), context);
    final Number value = ((Number) _interpretAdapt);
    final double abs = Math.abs(value.doubleValue());
    return ((Double) Double.valueOf(abs));
  }
  
  public Object _interpret(final MathModulo e, final ContextRobLANG context) {
    Object _interpretAdapt = this.interpretAdapt(e.getLhs(), context);
    final Number lhs = ((Number) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getRhs(), context);
    final Number rhs = ((Number) _interpretAdapt_1);
    double _doubleValue = lhs.doubleValue();
    double _doubleValue_1 = rhs.doubleValue();
    double _modulo = (_doubleValue % _doubleValue_1);
    return ((Double) Double.valueOf(_modulo));
  }
  
  public Object _interpret(final AnnotatedStatement e, final ContextRobLANG context) {
    final String softgoalID = e.getProperty().getLiteral();
    Object _interpretAdapt = this.interpretAdapt(e.getLowerBound(), context);
    final Number low = ((Number) _interpretAdapt);
    Object _interpretAdapt_1 = this.interpretAdapt(e.getHigherBound(), context);
    final Number high = ((Number) _interpretAdapt_1);
    context.pushAdaptationBounds(softgoalID, low.doubleValue(), high.doubleValue());
    this.interpretAdapt(e.getStatement(), context);
    context.popAdaptationBounds(softgoalID);
    return null;
  }
  
  public Object _interpret(final Statement e, final ContextRobLANG context) {
    return null;
  }
  
  public Object _interpret(final Robot e, final ContextRobLANG context) {
    Object res = ((Object) null);
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(e.getFunctions(), Object.class)).length); i++) {
      {
        FunDefinition _get = e.getFunctions().get(i);
        FunDefinition f = ((FunDefinition) _get);
        String _name = f.getName();
        boolean _equals = Objects.equal(_name, "Main");
        if (_equals) {
          final FunCall callMain = RobLANGFactoryImpl.eINSTANCE.createFunCall();
          callMain.setFunction(f);
          res = this.interpretAdapt(callMain, context);
        }
      }
    }
    return res;
  }
  
  public Object interpretAdapt(final EObject e, final ContextRobLANG context) {
    return this.interpret(e, context);
  }
  
  public Object interpret(final EObject e, final ContextRobLANG context) {
    if (e instanceof ArrayGet) {
      return _interpret((ArrayGet)e, context);
    } else if (e instanceof ArrayLength) {
      return _interpret((ArrayLength)e, context);
    } else if (e instanceof ArrayNew) {
      return _interpret((ArrayNew)e, context);
    } else if (e instanceof MathAbs) {
      return _interpret((MathAbs)e, context);
    } else if (e instanceof MathCos) {
      return _interpret((MathCos)e, context);
    } else if (e instanceof MathModulo) {
      return _interpret((MathModulo)e, context);
    } else if (e instanceof MathPow) {
      return _interpret((MathPow)e, context);
    } else if (e instanceof MathSin) {
      return _interpret((MathSin)e, context);
    } else if (e instanceof MathSqrt) {
      return _interpret((MathSqrt)e, context);
    } else if (e instanceof MoveBackward) {
      return _interpret((MoveBackward)e, context);
    } else if (e instanceof MoveForward) {
      return _interpret((MoveForward)e, context);
    } else if (e instanceof SenseBattery) {
      return _interpret((SenseBattery)e, context);
    } else if (e instanceof SenseCompass) {
      return _interpret((SenseCompass)e, context);
    } else if (e instanceof SenseDistance) {
      return _interpret((SenseDistance)e, context);
    } else if (e instanceof SensePosition) {
      return _interpret((SensePosition)e, context);
    } else if (e instanceof SenseTime) {
      return _interpret((SenseTime)e, context);
    } else if (e instanceof SetNominalSpeed) {
      return _interpret((SetNominalSpeed)e, context);
    } else if (e instanceof TurnLeft) {
      return _interpret((TurnLeft)e, context);
    } else if (e instanceof TurnRight) {
      return _interpret((TurnRight)e, context);
    } else if (e instanceof And) {
      return _interpret((And)e, context);
    } else if (e instanceof ArrayAdd) {
      return _interpret((ArrayAdd)e, context);
    } else if (e instanceof ArrayRemove) {
      return _interpret((ArrayRemove)e, context);
    } else if (e instanceof ArraySet) {
      return _interpret((ArraySet)e, context);
    } else if (e instanceof BoolConstant) {
      return _interpret((BoolConstant)e, context);
    } else if (e instanceof Divide) {
      return _interpret((Divide)e, context);
    } else if (e instanceof DoubleConstant) {
      return _interpret((DoubleConstant)e, context);
    } else if (e instanceof Equality) {
      return _interpret((Equality)e, context);
    } else if (e instanceof FunCall) {
      return _interpret((FunCall)e, context);
    } else if (e instanceof Greater) {
      return _interpret((Greater)e, context);
    } else if (e instanceof GreaterEq) {
      return _interpret((GreaterEq)e, context);
    } else if (e instanceof Inequality) {
      return _interpret((Inequality)e, context);
    } else if (e instanceof IntConstant) {
      return _interpret((IntConstant)e, context);
    } else if (e instanceof Less) {
      return _interpret((Less)e, context);
    } else if (e instanceof LessEq) {
      return _interpret((LessEq)e, context);
    } else if (e instanceof Minus) {
      return _interpret((Minus)e, context);
    } else if (e instanceof Multiply) {
      return _interpret((Multiply)e, context);
    } else if (e instanceof Not) {
      return _interpret((Not)e, context);
    } else if (e instanceof Or) {
      return _interpret((Or)e, context);
    } else if (e instanceof Plus) {
      return _interpret((Plus)e, context);
    } else if (e instanceof StringConstant) {
      return _interpret((StringConstant)e, context);
    } else if (e instanceof SymbolRef) {
      return _interpret((SymbolRef)e, context);
    } else if (e instanceof Assignment) {
      return _interpret((Assignment)e, context);
    } else if (e instanceof Break) {
      return _interpret((Break)e, context);
    } else if (e instanceof Condition) {
      return _interpret((Condition)e, context);
    } else if (e instanceof Expression) {
      return _interpret((Expression)e, context);
    } else if (e instanceof Loop) {
      return _interpret((Loop)e, context);
    } else if (e instanceof PrintExpression) {
      return _interpret((PrintExpression)e, context);
    } else if (e instanceof Return) {
      return _interpret((Return)e, context);
    } else if (e instanceof Variable) {
      return _interpret((Variable)e, context);
    } else if (e instanceof AnnotatedStatement) {
      return _interpret((AnnotatedStatement)e, context);
    } else if (e instanceof FunParamCapture) {
      return _interpret((FunParamCapture)e, context);
    } else if (e instanceof FunParamExp) {
      return _interpret((FunParamExp)e, context);
    } else if (e instanceof Block) {
      return _interpret((Block)e, context);
    } else if (e instanceof Robot) {
      return _interpret((Robot)e, context);
    } else if (e instanceof Statement) {
      return _interpret((Statement)e, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e, context).toString());
    }
  }
}
