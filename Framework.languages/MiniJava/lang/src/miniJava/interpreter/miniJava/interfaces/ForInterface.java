package miniJava.interpreter.miniJava.interfaces;

import java.util.ArrayList;
import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface;
import miniJava.interpreter.miniJava.Assignment;
import miniJava.interpreter.miniJava.Block;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Statement;

public class ForInterface implements SemanticsAdaptationInterface {
	private Assignment declaration;
	private Expression condition;
	private Assignment progression;
	private Block block;
	private List<Statement> toAdd;
	
	public ForInterface(Assignment declaration, Expression condition, Assignment progression, Block block) {
		this.declaration = declaration;
		this.condition = condition;
		this.progression = progression;
		this.block = block;
		this.toAdd = new ArrayList();
	}
	public Assignment getDeclaration() {
		return declaration;
	}
	public Assignment getProgression() {
		return progression;
	}
	public void setProgression(Assignment progression) {
		this.progression = progression;
	}
	public Expression getCondition() {
		return condition;
	}
	public Block getBlock() {
		return block;
	}
	
	public void addStatement(Statement st) {
		toAdd.add(st);
	}
	
	public List<Statement> getStatement() {
		return toAdd;
	}
	
}
