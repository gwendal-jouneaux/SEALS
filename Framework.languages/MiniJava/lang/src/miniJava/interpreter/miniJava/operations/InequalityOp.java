package miniJava.interpreter.miniJava.operations;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Inequality;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;

@Operationalize(node = Inequality.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class InequalityOp extends Operation<Inequality>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Inequality node, Object execCtx) {
		Value result;
		Value left = ((Value) (((Expression) (node.getLeft())).accept(vis,(State) (execCtx))));
		Value right = ((Value) (((Expression) (node.getRight())).accept(vis,(State) (execCtx))));
		boolean tmp = ((boolean) (false));
		if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				IntegerValue ileft = ((IntegerValue) (left));
				IntegerValue iright = ((IntegerValue) (right));
				tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
			}
		}
		else {
			if (left instanceof StringValue) {
				if (right instanceof StringValue) {
					StringValue ileft = ((StringValue) (left));
					StringValue iright = ((StringValue) (right));
					tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
				}
			}
			else {
				if (left instanceof BooleanValue) {
					if (right instanceof BooleanValue) {
						BooleanValue ileft = ((BooleanValue) (left));
						BooleanValue iright = ((BooleanValue) (right));
						tmp = EqualService.equals((ileft.isValue()), (iright.isValue()));
					}
				}
				else {
					if (left instanceof NullValue) {
						if (right instanceof NullValue) {
							tmp = true;
						}
					}
					else {
						if (left instanceof ObjectRefValue) {
							if (right instanceof ObjectRefValue) {
								ObjectRefValue ileft = ((ObjectRefValue) (left));
								ObjectRefValue iright = ((ObjectRefValue) (right));
								tmp = EqualService.equals((ileft.getInstance()), (iright.getInstance()));
							}
						}
					}
				}
			}
		}
		BooleanValue tmpo = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmpo.setValue(!(tmp));
		result = (Value) (tmpo) ;
		return result;
	}
}
