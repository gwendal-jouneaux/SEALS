package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolRef;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = SymbolRef.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class SymbolRefOp extends Operation<SymbolRef>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, SymbolRef node, Object execCtx) {
		Value result;
		result = (Value) (((Value) (((Context) (((State) (execCtx)).findCurrentContext())).findBinding((Symbol) (node.getSymbol())).getValue())).copyj()) ;
		return result;
	}
}
