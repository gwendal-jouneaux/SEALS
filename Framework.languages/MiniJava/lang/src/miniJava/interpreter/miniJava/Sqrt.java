package miniJava.interpreter.miniJava;

import org.eclipse.emf.ecore.EObject;

public interface Sqrt extends EObject, Expression {
	Expression getExpression();

	void setExpression(Expression value);
}
