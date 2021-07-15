package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import java.util.HashMap;

import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.runtime.FunctionReturn;
import fr.gwendal_jouneaux.rob_lang.robLANG.ComplexFunction;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunCall;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunDefinition;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParam;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunParamCapture;
import fr.gwendal_jouneaux.rob_lang.robLANG.InlineFunction;

@Operationalize(node = FunCall.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class FunCallOp extends Operation<FunCall> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, FunCall e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
		final FunDefinition function = e.getFunction();
	    HashMap<String, Object> params = new HashMap<String, Object>();
	    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(function.getVarNames(), Object.class)).length); i++) {
	      params.put(function.getVarNames().get(i).getName(), ((FunParam) e.getParams().get(i)).accept(vis, context));
	    }
	    context.pushContext(params);
	    Object res = ((Object) null);
	    if ((function instanceof InlineFunction)) {
	      res = ((InlineFunction)function).getExpression().accept(vis, context);
	    }
	    if ((function instanceof ComplexFunction)) {
	      try {
	        res = ((ComplexFunction)function).getBody().accept(vis, context);
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

}