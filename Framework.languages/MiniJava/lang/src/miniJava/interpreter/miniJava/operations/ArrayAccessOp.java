package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.ArrayAccess;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = ArrayAccess.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class ArrayAccessOp extends Operation<ArrayAccess>{


	@Override
	public Object execute(SelfAdaptiveVisitor vis, ArrayAccess node, Object execCtx) {
		Value result;
		ArrayRefValue arrayVal = ((ArrayRefValue) (((ArrayRefValue) (((Expression) (node.getObject())).accept(vis,(State) (execCtx))))));
		IntegerValue indexVal = ((IntegerValue) (((IntegerValue) (((Expression) (node.getIndex())).accept(vis,(State) (execCtx))))));
		int v = ((int) (indexVal.getValue()));
		Value vtmp = ((Value) (CollectionService.get(arrayVal.getInstance().getValue(), v)));
		result = (Value) (((Value) (vtmp)).copyj()) ;
		return result;
	}
}
