package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.ArrayTypeRef;
import miniJava.interpreter.miniJava.BooleanTypeRef;
import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.ClassRef;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerTypeRef;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewArray;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringTypeRef;
import miniJava.interpreter.miniJava.TypeRef;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = NewArray.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class NewArrayOp extends Operation<NewArray>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, NewArray node, Object execCtx) {
		Value result;
		ArrayInstance res = ((ArrayInstance) (MiniJavaFactory.eINSTANCE.createArrayInstance()));
		IntegerValue sizeArray = ((IntegerValue) (((IntegerValue) (((Expression) (node.getSize())).accept(vis,(State) (execCtx))))));
		res.setSize(sizeArray.getValue());
		((State) execCtx).getArraysHeap().add(res);
		Value defaultValue = ((Value) (null));
		if (node.getType() instanceof IntegerTypeRef) {
			IntegerValue idv = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
			idv.setValue(0);
			defaultValue = idv;
		}
		else {
			if (node.getType() instanceof BooleanTypeRef) {
				BooleanValue idv = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				idv.setValue(false);
				defaultValue = idv;
			}
			else {
				if (node.getType() instanceof StringTypeRef) {
					NullValue idv = ((NullValue) (MiniJavaFactory.eINSTANCE.createNullValue()));
					defaultValue = idv;
				}
				else {
					if (((node.getType() instanceof ClassRef) || (node.getType() instanceof ArrayTypeRef))) {
						NullValue idv = ((NullValue) (MiniJavaFactory.eINSTANCE.createNullValue()));
						defaultValue = idv;
					}
				}
			}
		}
		int i = ((int) (0));
		int sz = ((int) (res.getSize()));
		while ((i) < (sz)) {
			Value dv = ((Value) (defaultValue));
			Value v = ((Value) (((Value) (dv)).copyj()));
			res.getValue().add(v);
			i = (i) + (1);
		}
		ArrayRefValue ret = ((ArrayRefValue) (MiniJavaFactory.eINSTANCE.createArrayRefValue()));
		ret.setInstance(res);
		result = (Value) (ret) ;
		return result;
	}
}
