package miniJava.interpreter;

public class MiniJavaVisitor implements fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor {
	public Object visitLoadImage(miniJava.interpreter.miniJava.LoadImage node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.LoadImageOp()).execute(this,node,execCtx);}
	public Object visitBlock(miniJava.interpreter.miniJava.Block node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.BlockOp()).execute(this,node,execCtx);}
	public Object visitFieldAccess(miniJava.interpreter.miniJava.FieldAccess node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.FieldAccessOp()).execute(this,node,execCtx);}
	public Object visitMethodCall(miniJava.interpreter.miniJava.MethodCall node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.MethodCallOp()).execute(this,node,execCtx);}
	public Object visitSuperior(miniJava.interpreter.miniJava.Superior node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.SuperiorOp()).execute(this,node,execCtx);}
	public Object visitMultiplication(miniJava.interpreter.miniJava.Multiplication node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.MultiplicationOp()).execute(this,node,execCtx);}
	public Object visitForStatement(miniJava.interpreter.miniJava.ForStatement node, Object execCtx, miniJava.interpreter.miniJava.interfaces.ForInterface config){ return (new miniJava.interpreter.miniJava.operations.ForStatementOp()).execute(this,node,execCtx,config);}
	public Object visitReturn(miniJava.interpreter.miniJava.Return node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ReturnOp()).execute(this,node,execCtx);}
	public Object visitNewArray(miniJava.interpreter.miniJava.NewArray node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.NewArrayOp()).execute(this,node,execCtx);}
	public Object visitInferiorOrEqual(miniJava.interpreter.miniJava.InferiorOrEqual node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.InferiorOrEqualOp()).execute(this,node,execCtx);}
	public Object visitInferior(miniJava.interpreter.miniJava.Inferior node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.InferiorOp()).execute(this,node,execCtx);}
	public Object visitDivision(miniJava.interpreter.miniJava.Division node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.DivisionOp()).execute(this,node,execCtx);}
	public Object visitNot(miniJava.interpreter.miniJava.Not node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.NotOp()).execute(this,node,execCtx);}
	public Object visitAssignment(miniJava.interpreter.miniJava.Assignment node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.AssignmentOp()).execute(this,node,execCtx);}
	public Object visitNewObject(miniJava.interpreter.miniJava.NewObject node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.NewObjectOp()).execute(this,node,execCtx);}
	public Object visitEquality(miniJava.interpreter.miniJava.Equality node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.EqualityOp()).execute(this,node,execCtx);}
	public Object visitArrayLength(miniJava.interpreter.miniJava.ArrayLength node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ArrayLengthOp()).execute(this,node,execCtx);}
	public Object visitIfStatement(miniJava.interpreter.miniJava.IfStatement node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.IfStatementOp()).execute(this,node,execCtx);}
	public Object visitSqrt(miniJava.interpreter.miniJava.Sqrt node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.SqrtOp()).execute(this,node,execCtx);}
	public Object visitStringConstant(miniJava.interpreter.miniJava.StringConstant node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.StringConstantOp()).execute(this,node,execCtx);}
	public Object visitModulo(miniJava.interpreter.miniJava.Modulo node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ModuloOp()).execute(this,node,execCtx);}
	public Object visitInequality(miniJava.interpreter.miniJava.Inequality node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.InequalityOp()).execute(this,node,execCtx);}
	public Object visitWhileStatement(miniJava.interpreter.miniJava.WhileStatement node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.WhileStatementOp()).execute(this,node,execCtx);}
	public Object visitThis(miniJava.interpreter.miniJava.This node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ThisOp()).execute(this,node,execCtx);}
	public Object visitSymbolRef(miniJava.interpreter.miniJava.SymbolRef node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.SymbolRefOp()).execute(this,node,execCtx);}
	public Object visitProgram(miniJava.interpreter.miniJava.Program node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ProgramOp()).execute(this,node,execCtx);}
	public Object visitNull(miniJava.interpreter.miniJava.Null node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.NullOp()).execute(this,node,execCtx);}
	public Object visitIntConstant(miniJava.interpreter.miniJava.IntConstant node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.IntConstantOp()).execute(this,node,execCtx);}
	public Object visitBoolConstant(miniJava.interpreter.miniJava.BoolConstant node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.BoolConstantOp()).execute(this,node,execCtx);}
	public Object visitAnd(miniJava.interpreter.miniJava.And node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.AndOp()).execute(this,node,execCtx);}
	public Object visitArrayAccess(miniJava.interpreter.miniJava.ArrayAccess node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.ArrayAccessOp()).execute(this,node,execCtx);}
	public Object visitPrintStatement(miniJava.interpreter.miniJava.PrintStatement node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.PrintStatementOp()).execute(this,node,execCtx);}
	public Object visitNeg(miniJava.interpreter.miniJava.Neg node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.NegOp()).execute(this,node,execCtx);}
	public Object visitSuperiorOrEqual(miniJava.interpreter.miniJava.SuperiorOrEqual node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.SuperiorOrEqualOp()).execute(this,node,execCtx);}
	public Object visitWriteImage(miniJava.interpreter.miniJava.WriteImage node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.WriteImageOp()).execute(this,node,execCtx);}
	public Object visitMinus(miniJava.interpreter.miniJava.Minus node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.MinusOp()).execute(this,node,execCtx);}
	public Object visitPlus(miniJava.interpreter.miniJava.Plus node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.PlusOp()).execute(this,node,execCtx);}
	public Object visitMethod(miniJava.interpreter.miniJava.Method node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.MethodOp()).execute(this,node,execCtx);}
	public Object visitOr(miniJava.interpreter.miniJava.Or node, Object execCtx){ return (new miniJava.interpreter.miniJava.operations.OrOp()).execute(this,node,execCtx);}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.Node node, Object executionCtx){
		if(node instanceof miniJava.interpreter.miniJava.LoadImage){
			return visitLoadImage((miniJava.interpreter.miniJava.LoadImage) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Block){
			return visitBlock((miniJava.interpreter.miniJava.Block) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.FieldAccess){
			return visitFieldAccess((miniJava.interpreter.miniJava.FieldAccess) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.MethodCall){
			return visitMethodCall((miniJava.interpreter.miniJava.MethodCall) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Superior){
			return visitSuperior((miniJava.interpreter.miniJava.Superior) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Multiplication){
			return visitMultiplication((miniJava.interpreter.miniJava.Multiplication) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Return){
			return visitReturn((miniJava.interpreter.miniJava.Return) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.NewArray){
			return visitNewArray((miniJava.interpreter.miniJava.NewArray) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.InferiorOrEqual){
			return visitInferiorOrEqual((miniJava.interpreter.miniJava.InferiorOrEqual) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Inferior){
			return visitInferior((miniJava.interpreter.miniJava.Inferior) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Division){
			return visitDivision((miniJava.interpreter.miniJava.Division) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Not){
			return visitNot((miniJava.interpreter.miniJava.Not) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Assignment){
			return visitAssignment((miniJava.interpreter.miniJava.Assignment) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.NewObject){
			return visitNewObject((miniJava.interpreter.miniJava.NewObject) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Equality){
			return visitEquality((miniJava.interpreter.miniJava.Equality) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.ArrayLength){
			return visitArrayLength((miniJava.interpreter.miniJava.ArrayLength) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.IfStatement){
			return visitIfStatement((miniJava.interpreter.miniJava.IfStatement) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Sqrt){
			return visitSqrt((miniJava.interpreter.miniJava.Sqrt) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.StringConstant){
			return visitStringConstant((miniJava.interpreter.miniJava.StringConstant) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Modulo){
			return visitModulo((miniJava.interpreter.miniJava.Modulo) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Inequality){
			return visitInequality((miniJava.interpreter.miniJava.Inequality) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.WhileStatement){
			return visitWhileStatement((miniJava.interpreter.miniJava.WhileStatement) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.This){
			return visitThis((miniJava.interpreter.miniJava.This) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.SymbolRef){
			return visitSymbolRef((miniJava.interpreter.miniJava.SymbolRef) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Program){
			return visitProgram((miniJava.interpreter.miniJava.Program) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Null){
			return visitNull((miniJava.interpreter.miniJava.Null) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.IntConstant){
			return visitIntConstant((miniJava.interpreter.miniJava.IntConstant) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.BoolConstant){
			return visitBoolConstant((miniJava.interpreter.miniJava.BoolConstant) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.And){
			return visitAnd((miniJava.interpreter.miniJava.And) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.ArrayAccess){
			return visitArrayAccess((miniJava.interpreter.miniJava.ArrayAccess) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.PrintStatement){
			return visitPrintStatement((miniJava.interpreter.miniJava.PrintStatement) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Neg){
			return visitNeg((miniJava.interpreter.miniJava.Neg) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.SuperiorOrEqual){
			return visitSuperiorOrEqual((miniJava.interpreter.miniJava.SuperiorOrEqual) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.WriteImage){
			return visitWriteImage((miniJava.interpreter.miniJava.WriteImage) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Minus){
			return visitMinus((miniJava.interpreter.miniJava.Minus) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Plus){
			return visitPlus((miniJava.interpreter.miniJava.Plus) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Method){
			return visitMethod((miniJava.interpreter.miniJava.Method) node, executionCtx);
		}
		if(node instanceof miniJava.interpreter.miniJava.Or){
			return visitOr((miniJava.interpreter.miniJava.Or) node, executionCtx);
		}
		return null;
	}
	public Object dispatch(fr.gjouneau.savm.framework.lang.semantics.AdaptableNode node, Object executionCtx, fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface config){
		if(node instanceof miniJava.interpreter.miniJava.ForStatement){
			return visitForStatement((miniJava.interpreter.miniJava.ForStatement) node, executionCtx,(miniJava.interpreter.miniJava.interfaces.ForInterface) config);
		}
		return null;
	}
}