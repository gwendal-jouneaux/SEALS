package fr.gjouneau.self.adaptation.framework.HTML.nodes.operations;

import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeEmptyTag;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.TagInterface;

@Operationalize(node = HTMLNodeEmptyTag.class, visitor="fr.gjouneau.self.adaptation.framework.HTML.PrettyPrinter")
public class HTMLOperationEmptyTag extends AdaptiveOperation<HTMLNodeEmptyTag, TagInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, HTMLNodeEmptyTag node, Object execCtx, TagInterface config) {
		String out = "<"+config.getTag();
		List<HTMLNodeAttribute> attributes = config.getAttributes();
		for (HTMLNodeAttribute htmlNodeAttribute : attributes) {
			out += " "+htmlNodeAttribute.accept(vis, execCtx);
		}
		out += "/>";
		return out;
	}

}
