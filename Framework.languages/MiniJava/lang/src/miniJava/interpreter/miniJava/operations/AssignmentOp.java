package miniJava.interpreter.miniJava.operations;

import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.ArrayAccess;
import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.Assignee;
import miniJava.interpreter.miniJava.Assignment;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldAccess;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Symbol;
import miniJava.interpreter.miniJava.SymbolBinding;
import miniJava.interpreter.miniJava.SymbolRef;
import miniJava.interpreter.miniJava.Value;
import miniJava.interpreter.miniJava.VariableDeclaration;
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

@Operationalize(node = Assignment.class, visitor = "miniJava.interpreter.MiniJavaVisitor")
public class AssignmentOp extends Operation<Assignment>{
	
	@Override
	public Object execute(SelfAdaptiveVisitor vis, Assignment node, Object execCtx) {
		Context context = ((Context) (((State) (execCtx)).findCurrentContext()));
		Value right = ((Value) (((Expression) (node.getValue())).accept(vis,(State) (execCtx))));
		Assignee assignee = ((Assignee) (node.getAssignee()));
		if (assignee instanceof SymbolRef) {
			SymbolRef assigneeSymbolRef = ((SymbolRef) (assignee));
			SymbolBinding existingBinding = ((SymbolBinding) (((Context) (context)).findBinding((Symbol) (assigneeSymbolRef.getSymbol()))));
			existingBinding.setValue(right);
		}
		else {
			if (assignee instanceof VariableDeclaration) {
				VariableDeclaration assigneeVariableDeclaration = ((VariableDeclaration) (assignee));
				SymbolBinding binding = ((SymbolBinding) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(assigneeVariableDeclaration);
				binding.setValue(right);
				context.getBindings().add(binding);
			}
			else {
				if (assignee instanceof FieldAccess) {
					FieldAccess assigneeFieldAccess = ((FieldAccess) (assignee));
					Field f = ((Field) (assigneeFieldAccess.getField()));
					ObjectRefValue realReceiverValue = ((ObjectRefValue) (((ObjectRefValue) (((Expression) (assigneeFieldAccess.getReceiver())).accept(vis,(State) (execCtx))))));
					ObjectInstance realReceiver = ((ObjectInstance) (realReceiverValue.getInstance()));
					FieldBinding existingBinding = ((FieldBinding) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (f))))));
					if (EqualService.equals((existingBinding), (null))) {
						FieldBinding binding = ((FieldBinding) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
						binding.setField(f);
						binding.setValue(right);
						realReceiver.getFieldbindings().add(binding);
					}
					else {
						existingBinding.setValue(right);
					}
				}
				else {
					if (assignee instanceof ArrayAccess) {
						ArrayAccess assigneeArrayAccess = ((ArrayAccess) (assignee));
						ArrayRefValue arrayRefValue = ((ArrayRefValue) (((ArrayRefValue) (((Expression) (assigneeArrayAccess.getObject())).accept(vis,(State) (execCtx))))));
						ArrayInstance array = ((ArrayInstance) (arrayRefValue.getInstance()));
						IntegerValue integerValue = ((IntegerValue) (((IntegerValue) (((Expression) (assigneeArrayAccess.getIndex())).accept(vis,(State) (execCtx))))));
						int index = ((int) (integerValue.getValue()));
						CollectionService.set(array.getValue(), index, right);
					}
					else {
					}
				}
			}
		}
		return null;
	}
}
