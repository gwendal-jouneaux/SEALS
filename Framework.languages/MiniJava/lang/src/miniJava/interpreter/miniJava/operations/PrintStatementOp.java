package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.PrintStatement;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = PrintStatement.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class PrintStatementOp extends Operation<PrintStatement>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, PrintStatement node, Object execCtx) {
		String res = ((String) (((Value) (((Expression) (node.getExpression())).accept(vis,(State) (execCtx)))).customToString()));
		((State) (execCtx)).println((String) (res));
		return null;
	}
}
