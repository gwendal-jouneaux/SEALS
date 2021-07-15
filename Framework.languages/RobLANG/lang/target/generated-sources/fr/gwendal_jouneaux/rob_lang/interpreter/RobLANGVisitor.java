package fr.gwendal_jouneaux.rob_lang.interpreter;

public class RobLANGVisitor implements fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor {
	public Object visitIntConstant(fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.IntConstantOp()).execute(this,node,execCtx);}
	public Object visitReturn(fr.gwendal_jouneaux.rob_lang.robLANG.Return node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ReturnOp()).execute(this,node,execCtx);}
	public Object visitSenseTime(fr.gwendal_jouneaux.rob_lang.robLANG.SenseTime node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SenseTimeOp()).execute(this,node,execCtx);}
	public Object visitLoop(fr.gwendal_jouneaux.rob_lang.robLANG.Loop node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.LoopOp()).execute(this,node,execCtx);}
	public Object visitPlus(fr.gwendal_jouneaux.rob_lang.robLANG.Plus node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.PlusOp()).execute(this,node,execCtx);}
	public Object visitBlock(fr.gwendal_jouneaux.rob_lang.robLANG.Block node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.BlockOp()).execute(this,node,execCtx);}
	public Object visitRobot(fr.gwendal_jouneaux.rob_lang.robLANG.Robot node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.RobotOp()).execute(this,node,execCtx);}
	public Object visitArrayNew(fr.gwendal_jouneaux.rob_lang.robLANG.ArrayNew node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArrayNewOp()).execute(this,node,execCtx);}
	public Object visitMathCos(fr.gwendal_jouneaux.rob_lang.robLANG.MathCos node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathCosOp()).execute(this,node,execCtx);}
	public Object visitArrayAdd(fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArrayAddOp()).execute(this,node,execCtx);}
	public Object visitSenseCompass(fr.gwendal_jouneaux.rob_lang.robLANG.SenseCompass node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SenseCompassOp()).execute(this,node,execCtx);}
	public Object visitBoolConstant(fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.BoolConstantOp()).execute(this,node,execCtx);}
	public Object visitPrintExpression(fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.PrintExpressionOp()).execute(this,node,execCtx);}
	public Object visitArrayGet(fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArrayGetOp()).execute(this,node,execCtx);}
	public Object visitMinus(fr.gwendal_jouneaux.rob_lang.robLANG.Minus node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MinusOp()).execute(this,node,execCtx);}
	public Object visitGreater(fr.gwendal_jouneaux.rob_lang.robLANG.Greater node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.GreaterOp()).execute(this,node,execCtx);}
	public Object visitTurnLeft(fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft node, Object execCtx, fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface config){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.TurnLeftOp()).execute(this,node,execCtx,config);}
	public Object visitMathSin(fr.gwendal_jouneaux.rob_lang.robLANG.MathSin node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathSinOp()).execute(this,node,execCtx);}
	public Object visitNot(fr.gwendal_jouneaux.rob_lang.robLANG.Not node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.NotOp()).execute(this,node,execCtx);}
	public Object visitFunParamCapture(fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.FunParamCaptureOp()).execute(this,node,execCtx);}
	public Object visitArrayLength(fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArrayLengthOp()).execute(this,node,execCtx);}
	public Object visitSenseBattery(fr.gwendal_jouneaux.rob_lang.robLANG.SenseBattery node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SenseBatteryOp()).execute(this,node,execCtx);}
	public Object visitLess(fr.gwendal_jouneaux.rob_lang.robLANG.Less node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.LessOp()).execute(this,node,execCtx);}
	public Object visitMoveBackward(fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward node, Object execCtx, fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface config){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MoveBackwardOp()).execute(this,node,execCtx,config);}
	public Object visitFunParamExp(fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.FunParamExpOp()).execute(this,node,execCtx);}
	public Object visitLessEq(fr.gwendal_jouneaux.rob_lang.robLANG.LessEq node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.LessEqOp()).execute(this,node,execCtx);}
	public Object visitSensePosition(fr.gwendal_jouneaux.rob_lang.robLANG.SensePosition node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SensePositionOp()).execute(this,node,execCtx);}
	public Object visitMathModulo(fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathModuloOp()).execute(this,node,execCtx);}
	public Object visitDivide(fr.gwendal_jouneaux.rob_lang.robLANG.Divide node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.DivideOp()).execute(this,node,execCtx);}
	public Object visitBreak(fr.gwendal_jouneaux.rob_lang.robLANG.Break node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.BreakOp()).execute(this,node,execCtx);}
	public Object visitMathSqrt(fr.gwendal_jouneaux.rob_lang.robLANG.MathSqrt node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathSqrtOp()).execute(this,node,execCtx);}
	public Object visitMathAbs(fr.gwendal_jouneaux.rob_lang.robLANG.MathAbs node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathAbsOp()).execute(this,node,execCtx);}
	public Object visitMoveForward(fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward node, Object execCtx, fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface config){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MoveForwardOp()).execute(this,node,execCtx,config);}
	public Object visitArraySet(fr.gwendal_jouneaux.rob_lang.robLANG.ArraySet node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArraySetOp()).execute(this,node,execCtx);}
	public Object visitVariable(fr.gwendal_jouneaux.rob_lang.robLANG.Variable node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.VariableOp()).execute(this,node,execCtx);}
	public Object visitEquality(fr.gwendal_jouneaux.rob_lang.robLANG.Equality node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.EqualityOp()).execute(this,node,execCtx);}
	public Object visitFunCall(fr.gwendal_jouneaux.rob_lang.robLANG.FunCall node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.FunCallOp()).execute(this,node,execCtx);}
	public Object visitOr(fr.gwendal_jouneaux.rob_lang.robLANG.Or node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.OrOp()).execute(this,node,execCtx);}
	public Object visitSenseDistance(fr.gwendal_jouneaux.rob_lang.robLANG.SenseDistance node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SenseDistanceOp()).execute(this,node,execCtx);}
	public Object visitSetNominalSpeed(fr.gwendal_jouneaux.rob_lang.robLANG.SetNominalSpeed node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SetNominalSpeedOp()).execute(this,node,execCtx);}
	public Object visitInequality(fr.gwendal_jouneaux.rob_lang.robLANG.Inequality node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.InequalityOp()).execute(this,node,execCtx);}
	public Object visitTurnRight(fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight node, Object execCtx, fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface config){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.TurnRightOp()).execute(this,node,execCtx,config);}
	public Object visitCondition(fr.gwendal_jouneaux.rob_lang.robLANG.Condition node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ConditionOp()).execute(this,node,execCtx);}
	public Object visitAnnotatedEffector(fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedEffector node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.AnnotatedEffectorOp()).execute(this,node,execCtx);}
	public Object visitMultiply(fr.gwendal_jouneaux.rob_lang.robLANG.Multiply node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MultiplyOp()).execute(this,node,execCtx);}
	public Object visitMathPow(fr.gwendal_jouneaux.rob_lang.robLANG.MathPow node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.MathPowOp()).execute(this,node,execCtx);}
	public Object visitAnd(fr.gwendal_jouneaux.rob_lang.robLANG.And node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.AndOp()).execute(this,node,execCtx);}
	public Object visitAssignment(fr.gwendal_jouneaux.rob_lang.robLANG.Assignment node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.AssignmentOp()).execute(this,node,execCtx);}
	public Object visitGreaterEq(fr.gwendal_jouneaux.rob_lang.robLANG.GreaterEq node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.GreaterEqOp()).execute(this,node,execCtx);}
	public Object visitArrayRemove(fr.gwendal_jouneaux.rob_lang.robLANG.ArrayRemove node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.ArrayRemoveOp()).execute(this,node,execCtx);}
	public Object visitDoubleConstant(fr.gwendal_jouneaux.rob_lang.robLANG.DoubleConstant node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.DoubleConstantOp()).execute(this,node,execCtx);}
	public Object visitSymbolRef(fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.SymbolRefOp()).execute(this,node,execCtx);}
	public Object visitStringConstant(fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant node, Object execCtx){ return (new fr.gwendal_jouneaux.rob_lang.interpreter.operations.StringConstantOp()).execute(this,node,execCtx);}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.Node node, Object executionCtx){
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant){
			return visitIntConstant((fr.gwendal_jouneaux.rob_lang.robLANG.IntConstant) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Return){
			return visitReturn((fr.gwendal_jouneaux.rob_lang.robLANG.Return) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SenseTime){
			return visitSenseTime((fr.gwendal_jouneaux.rob_lang.robLANG.SenseTime) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Loop){
			return visitLoop((fr.gwendal_jouneaux.rob_lang.robLANG.Loop) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Plus){
			return visitPlus((fr.gwendal_jouneaux.rob_lang.robLANG.Plus) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Block){
			return visitBlock((fr.gwendal_jouneaux.rob_lang.robLANG.Block) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Robot){
			return visitRobot((fr.gwendal_jouneaux.rob_lang.robLANG.Robot) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArrayNew){
			return visitArrayNew((fr.gwendal_jouneaux.rob_lang.robLANG.ArrayNew) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathCos){
			return visitMathCos((fr.gwendal_jouneaux.rob_lang.robLANG.MathCos) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd){
			return visitArrayAdd((fr.gwendal_jouneaux.rob_lang.robLANG.ArrayAdd) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SenseCompass){
			return visitSenseCompass((fr.gwendal_jouneaux.rob_lang.robLANG.SenseCompass) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant){
			return visitBoolConstant((fr.gwendal_jouneaux.rob_lang.robLANG.BoolConstant) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression){
			return visitPrintExpression((fr.gwendal_jouneaux.rob_lang.robLANG.PrintExpression) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet){
			return visitArrayGet((fr.gwendal_jouneaux.rob_lang.robLANG.ArrayGet) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Minus){
			return visitMinus((fr.gwendal_jouneaux.rob_lang.robLANG.Minus) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Greater){
			return visitGreater((fr.gwendal_jouneaux.rob_lang.robLANG.Greater) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathSin){
			return visitMathSin((fr.gwendal_jouneaux.rob_lang.robLANG.MathSin) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Not){
			return visitNot((fr.gwendal_jouneaux.rob_lang.robLANG.Not) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture){
			return visitFunParamCapture((fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength){
			return visitArrayLength((fr.gwendal_jouneaux.rob_lang.robLANG.ArrayLength) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SenseBattery){
			return visitSenseBattery((fr.gwendal_jouneaux.rob_lang.robLANG.SenseBattery) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Less){
			return visitLess((fr.gwendal_jouneaux.rob_lang.robLANG.Less) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp){
			return visitFunParamExp((fr.gwendal_jouneaux.rob_lang.robLANG.FunParamExp) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.LessEq){
			return visitLessEq((fr.gwendal_jouneaux.rob_lang.robLANG.LessEq) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SensePosition){
			return visitSensePosition((fr.gwendal_jouneaux.rob_lang.robLANG.SensePosition) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo){
			return visitMathModulo((fr.gwendal_jouneaux.rob_lang.robLANG.MathModulo) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Divide){
			return visitDivide((fr.gwendal_jouneaux.rob_lang.robLANG.Divide) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Break){
			return visitBreak((fr.gwendal_jouneaux.rob_lang.robLANG.Break) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathSqrt){
			return visitMathSqrt((fr.gwendal_jouneaux.rob_lang.robLANG.MathSqrt) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathAbs){
			return visitMathAbs((fr.gwendal_jouneaux.rob_lang.robLANG.MathAbs) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArraySet){
			return visitArraySet((fr.gwendal_jouneaux.rob_lang.robLANG.ArraySet) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Variable){
			return visitVariable((fr.gwendal_jouneaux.rob_lang.robLANG.Variable) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Equality){
			return visitEquality((fr.gwendal_jouneaux.rob_lang.robLANG.Equality) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.FunCall){
			return visitFunCall((fr.gwendal_jouneaux.rob_lang.robLANG.FunCall) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Or){
			return visitOr((fr.gwendal_jouneaux.rob_lang.robLANG.Or) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SenseDistance){
			return visitSenseDistance((fr.gwendal_jouneaux.rob_lang.robLANG.SenseDistance) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SetNominalSpeed){
			return visitSetNominalSpeed((fr.gwendal_jouneaux.rob_lang.robLANG.SetNominalSpeed) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Inequality){
			return visitInequality((fr.gwendal_jouneaux.rob_lang.robLANG.Inequality) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Condition){
			return visitCondition((fr.gwendal_jouneaux.rob_lang.robLANG.Condition) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedEffector){
			return visitAnnotatedEffector((fr.gwendal_jouneaux.rob_lang.robLANG.AnnotatedEffector) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Multiply){
			return visitMultiply((fr.gwendal_jouneaux.rob_lang.robLANG.Multiply) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MathPow){
			return visitMathPow((fr.gwendal_jouneaux.rob_lang.robLANG.MathPow) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.And){
			return visitAnd((fr.gwendal_jouneaux.rob_lang.robLANG.And) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.Assignment){
			return visitAssignment((fr.gwendal_jouneaux.rob_lang.robLANG.Assignment) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.GreaterEq){
			return visitGreaterEq((fr.gwendal_jouneaux.rob_lang.robLANG.GreaterEq) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.ArrayRemove){
			return visitArrayRemove((fr.gwendal_jouneaux.rob_lang.robLANG.ArrayRemove) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.DoubleConstant){
			return visitDoubleConstant((fr.gwendal_jouneaux.rob_lang.robLANG.DoubleConstant) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef){
			return visitSymbolRef((fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef) node, executionCtx);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant){
			return visitStringConstant((fr.gwendal_jouneaux.rob_lang.robLANG.StringConstant) node, executionCtx);
		}
		return null;
	}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.AdaptableNode node, Object executionCtx, fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface config){
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft){
			return visitTurnLeft((fr.gwendal_jouneaux.rob_lang.robLANG.TurnLeft) node, executionCtx,(fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface) config);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward){
			return visitMoveBackward((fr.gwendal_jouneaux.rob_lang.robLANG.MoveBackward) node, executionCtx,(fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface) config);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward){
			return visitMoveForward((fr.gwendal_jouneaux.rob_lang.robLANG.MoveForward) node, executionCtx,(fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface) config);
		}
		if(node instanceof fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight){
			return visitTurnRight((fr.gwendal_jouneaux.rob_lang.robLANG.TurnRight) node, executionCtx,(fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.MotorAdaptationInterface) config);
		}
		return null;
	}
}