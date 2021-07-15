package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewCall;
import miniJava.interpreter.miniJava.NewObject;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;

@Operationalize(node = NewObject.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class NewObjectOp extends Operation<NewObject>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, NewObject node, Object execCtx) {
		Value result;
		ObjectInstance res = ((ObjectInstance) (MiniJavaFactory.eINSTANCE.createObjectInstance()));
		res.setType(node.getType());
		((State) execCtx).getObjectsHeap().add(res);
		int i = ((int) (0));
		int z = ((int) (CollectionService.size(res.getType().getMembers())));
		while ((i) < (z)) {
			Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
			if (m instanceof Field) {
				Field f = ((Field) (m));
				if (!EqualService.equals((f.getDefaultValue()), (null))) {
					Value v = ((Value) (((Expression) (f.getDefaultValue())).accept(vis,(State) (execCtx))));
					FieldBinding fb = ((FieldBinding) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
					fb.setField(f);
					fb.setValue(v);
					res.getFieldbindings().add(fb);
				}
			}
			i = (i) + (1);
		}
		i = 0;
		Method constructor = ((Method) (null));
		while ((((i) < (z)) && (EqualService.equals((constructor), (null))))) {
			Member m = ((Member) (CollectionService.get(res.getType().getMembers(), i)));
			if (m instanceof Method) {
				Method mtd = ((Method) (m));
				if (((EqualService.equals((mtd.getName()), (null))) && (EqualService.equals((CollectionService.size(mtd.getParams())), (CollectionService.size(node.getArgs())))))) {
					constructor = mtd;
				}
			}
			i = (i) + (1);
		}
		if (!EqualService.equals((constructor), (null))) {
			Context newContext = ((Context) (MiniJavaFactory.eINSTANCE.createContext()));
			i = 0;
			z = CollectionService.size(node.getArgs());
			while ((i) < (z)) {
				Expression arg = ((Expression) (CollectionService.get(node.getArgs(), i)));
				Parameter param = ((Parameter) (CollectionService.get(constructor.getParams(), i)));
				SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(param);
				binding.setValue((Value) ((Expression) (arg)).accept(vis,(State) (execCtx)));
				i = (i) + (1);
				newContext.getBindings().add(binding);
			}
			NewCall call = ((NewCall) (MiniJavaFactory.eINSTANCE.createNewCall()));
			call.setNewz(node);
			((State) (execCtx)).pushNewFrame((ObjectInstance) (res), (NewCall) (call), (Context) (newContext));
			Block bd = ((Block) (constructor.getBody()));
			((Block) (bd)).accept(vis,(State) (execCtx));
			((State) (execCtx)).popCurrentFrame();
		}
		ObjectRefValue tmp = ((ObjectRefValue) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(res);
		result = (Value) (tmp) ;
		return result;
	}
}
