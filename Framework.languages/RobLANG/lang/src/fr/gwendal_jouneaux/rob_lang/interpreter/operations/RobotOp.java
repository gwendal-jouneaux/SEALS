package fr.gwendal_jouneaux.rob_lang.interpreter.operations;

import org.eclipse.xtext.xbase.lib.Conversions;

import com.google.common.base.Objects;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunCall;
import fr.gwendal_jouneaux.rob_lang.robLANG.FunDefinition;
import fr.gwendal_jouneaux.rob_lang.robLANG.Robot;
import fr.gwendal_jouneaux.rob_lang.robLANG.impl.RobLANGFactoryImpl;

@Operationalize(node = Robot.class, visitor = "fr.gwendal_jouneaux.rob_lang.interpreter.RobLANGVisitor")
public class RobotOp extends Operation<Robot> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Robot e, Object execCtx) {
		final ContextRobLANG context = (ContextRobLANG) execCtx;
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
	          res = callMain.accept(vis, context);
	        }
	      }
	    }
	    return res;
	}

}