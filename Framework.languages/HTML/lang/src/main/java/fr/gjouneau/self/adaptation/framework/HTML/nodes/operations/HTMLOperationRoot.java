package fr.gjouneau.self.adaptation.framework.HTML.nodes.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot;

@Operationalize(node = HTMLNodeRoot.class, visitor="fr.gjouneau.self.adaptation.framework.HTML.PrettyPrinter")
public class HTMLOperationRoot extends Operation<HTMLNodeRoot>{

	@Override
	public Object execute(SelfAdaptiveVisitor vis, HTMLNodeRoot node, Object execCtx) {
		return "<!DOCTYPE html>\n" + node.getHtml().accept(vis, execCtx);
	}

}
