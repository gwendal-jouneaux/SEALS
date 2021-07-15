package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Plus;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = Plus.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class PlusOp extends Operation<Plus>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, Plus node, Object execCtx) {
		Value result;
		Value left = ((Value) (((Expression) (node.getLeft())).accept(vis,(State) (execCtx))));
		Value right = ((Value) (((Expression) (node.getRight())).accept(vis,(State) (execCtx))));
		if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				IntegerValue bleft = ((IntegerValue) (left));
				IntegerValue bright = ((IntegerValue) (right));
				IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
				tmp.setValue((bleft.getValue()) + (bright.getValue()));
				result = (Value) (tmp) ;
			}
			else {
				if (right instanceof StringValue) {
					StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
					tmp.setValue((((IntegerValue) (left)).customToString()) + (((StringValue) (right)).customToString()));
					result = (Value) (tmp) ;
				}
				else {
					result = (Value) (null) ;
				}
			}
		}
		else {
			if (left instanceof StringValue) {
				if (right instanceof IntegerValue) {
					StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
					tmp.setValue((((StringValue) (left)).customToString()) + (((IntegerValue) (right)).customToString()));
					result = (Value) (tmp) ;
				}
				else {
					if (right instanceof StringValue) {
						StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
						tmp.setValue((((StringValue) (left)).customToString()) + (((StringValue) (right)).customToString()));
						result = (Value) (tmp) ;
					}
					else {
						result = (Value) (null) ;
					}
				}
			}
			else {
				result = (Value) (null) ;
			}
		}
		return result;
	}
}
