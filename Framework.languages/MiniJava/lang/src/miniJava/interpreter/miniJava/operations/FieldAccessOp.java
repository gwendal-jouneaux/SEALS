package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldAccess;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = FieldAccess.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class FieldAccessOp extends Operation<FieldAccess>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, FieldAccess node, Object execCtx) {
		Value result;
		ObjectRefValue tmp0 = ((ObjectRefValue) (((Expression) (node.getReceiver())).accept(vis,(State) (execCtx))));
		ObjectInstance realReceiver = ((ObjectInstance) (tmp0.getInstance()));
		Field fld = ((Field) (node.getField()));
		FieldBinding fb = ((FieldBinding) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (fld))))));
		result = (Value) (fb.getValue()) ;
		return result;
	}
}
