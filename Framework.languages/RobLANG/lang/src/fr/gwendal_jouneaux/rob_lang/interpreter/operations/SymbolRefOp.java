package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.RuntimeArray;
import fr.gwendal_jouneaux.rob_lang.robLANG.SymbolRef;

@Operationalize(node = SymbolRef.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class SymbolRefOp extends Operation<SymbolRef> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SymbolRef e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		Object _xblockexpression = null;
	    {
	      boolean _isStringType = context.typer.isStringType(context.typer.typeFor(e.getVariable()));
	      if (_isStringType) {
	        Object _get = context.get(e.getVariable().getName());
	        return ((String) _get);
	      }
	      boolean _isIntType = context.typer.isIntType(context.typer.typeFor(e.getVariable()));
	      if (_isIntType) {
	        Object _get_1 = context.get(e.getVariable().getName());
	        return ((Integer) _get_1);
	      }
	      boolean _isBoolType = context.typer.isBoolType(context.typer.typeFor(e.getVariable()));
	      if (_isBoolType) {
	        Object _get_2 = context.get(e.getVariable().getName());
	        return ((Boolean) _get_2);
	      }
	      boolean _isDoubleType = context.typer.isDoubleType(context.typer.typeFor(e.getVariable()));
	      if (_isDoubleType) {
	        Object _get_3 = context.get(e.getVariable().getName());
	        return ((Double) _get_3);
	      }
	      boolean _isArrayType = context.typer.isArrayType(context.typer.typeFor(e.getVariable()));
	      if (_isArrayType) {
	        Object _get_4 = context.get(e.getVariable().getName());
	        return ((RuntimeArray) _get_4);
	      }
	      _xblockexpression = context.get(e.getVariable().getName());
	    }
	    return _xblockexpression;
	}

}