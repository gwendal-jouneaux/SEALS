package fr.gjouneau.self.adaptation.framework.HTML.nodes.operations;

import fr.gjouneau.savm.framework.lang.semantics.Operation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodePlainText;

@Operationalize(node = HTMLNodePlainText.class, visitor="fr.gjouneau.self.adaptation.framework.HTML.PrettyPrinter")
public class HTMLOperationPlainText extends Operation<HTMLNodePlainText> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, HTMLNodePlainText node, Object execCtx) {
		return node.getContent();
	}

}
