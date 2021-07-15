package fr.gjouneau.savm.framework.lang.semantics;

public abstract class Operation<N extends Node> {
	abstract public Object execute(SelfAdaptiveVisitor vis, N node, Object execCtx);
}
