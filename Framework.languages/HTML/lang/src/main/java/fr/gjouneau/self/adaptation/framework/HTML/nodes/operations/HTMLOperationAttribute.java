package fr.gjouneau.self.adaptation.framework.HTML.nodes.operations;

import fr.gjouneau.savm.framework.lang.semantics.AdaptiveOperation;
import fr.gjouneau.savm.framework.lang.semantics.Operationalize;
import fr.gjouneau.savm.framework.lang.semantics.SelfAdaptiveVisitor;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.AttributeInterface;

@Operationalize(node = HTMLNodeAttribute.class, visitor="fr.gjouneau.self.adaptation.framework.HTML.PrettyPrinter")
public class HTMLOperationAttribute extends AdaptiveOperation<HTMLNodeAttribute, AttributeInterface> {

	@Override
	public Object execute(SelfAdaptiveVisitor vis, HTMLNodeAttribute node, Object execCtx, AttributeInterface config) {
		if(node.getType() == null) return node.getName();
		switch (node.getType()) {
		case UNQUOTED:
			return node.getName()+"="+config.getValue();
		case SIMPLE_QUOTED:
			return node.getName()+"='"+config.getValue()+"'";
		case DOUBLE_QUOTED:
			return node.getName()+"=\""+config.getValue()+"\"";
		default:
			return node.getName();
		}
	}

}
