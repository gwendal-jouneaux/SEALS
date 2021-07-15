package fr.gjouneau.self.adaptation.framework.HTML.nodes;

import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.TagInterface;

public class HTMLNodeEmptyTag extends HTMLNodeBaseTag implements AdaptableNode<TagInterface>{

	public HTMLNodeEmptyTag(String tag, List<HTMLNodeAttribute> attributes) {
		super(tag, attributes);
	}

	@Override
	public TagInterface defaultInterface() {
		return new TagInterface(this);
	}
}
