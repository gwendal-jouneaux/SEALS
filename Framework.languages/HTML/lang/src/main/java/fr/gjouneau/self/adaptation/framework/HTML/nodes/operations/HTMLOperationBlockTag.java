package fr.gjouneau.self.adaptation.framework.HTML.nodes.operations;

import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBase;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBlockTag;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.BlockTagInterface;

@Operationalize(node = HTMLNodeBlockTag.class, visitor="fr.gjouneau.self.adaptation.framework.HTML.PrettyPrinter")
public class HTMLOperationBlockTag extends AdaptiveOperation<HTMLNodeBlockTag, BlockTagInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, HTMLNodeBlockTag node, Object execCtx, BlockTagInterface config) {
		String out = "<"+config.getTag();
		List<HTMLNodeAttribute> attributes = config.getAttributes();
		for (HTMLNodeAttribute htmlNodeAttribute : attributes) {
			out += " "+htmlNodeAttribute.accept(vis, execCtx);
		}
		out += ">";
		
		for (HTMLNodeBase child : config.getChildren()) {
			if(child != null) out += child.accept(vis, execCtx);
		}
		out += "</"+config.getTag() + ">";
		return out;
	}

}
