package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MethodCall2;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.SymbolBinding;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = MethodCall.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class MethodCallOp extends Operation<MethodCall>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, MethodCall node, Object execCtx) {
		Value result;
		ObjectRefValue realReceiver0 = ((ObjectRefValue) (((ObjectRefValue) (((Expression) (node.getReceiver())).accept(vis,(State) (execCtx))))));
		ObjectInstance realReceiver = ((ObjectInstance) (realReceiver0.getInstance()));
		Method realMethod = ((Method) (((Method) (((Method) (node.getMethod())).findOverride((Clazz) (realReceiver.getType()))))));
		Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
		int argsLength = ((int) (CollectionService.size(node.getArgs())));
		int i = ((int) (0));
		while ((i) < (argsLength)) {
			Expression arg = ((Expression) (CollectionService.get(node.getArgs(), i)));
			Parameter param = ((Parameter) (CollectionService.get(realMethod.getParams(), i)));
			SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
			binding.setSymbol(param);
			binding.setValue((Value) ((Expression) (arg)).accept(vis,(State) (execCtx)));
			newContext.getBindings().add(binding);
			i = (i) + (1);
		}
		MethodCall2 call = ((MethodCall2) (MiniJavaFactory.eINSTANCE.createMethodCall2()));
		call.setMethodcall(node);
		((State) (execCtx)).pushNewFrame((ObjectInstance) (realReceiver), (MethodCall2) (call), (Context) (newContext));
		
		((Method) (realMethod)).accept(vis, (State) (execCtx));
		
		Value returnValue = ((Value) (((State) (execCtx)).findCurrentFrame().getReturnValue()));
		((State) (execCtx)).popCurrentFrame();
		result = (Value) (returnValue) ;
		return result;
	}
}
