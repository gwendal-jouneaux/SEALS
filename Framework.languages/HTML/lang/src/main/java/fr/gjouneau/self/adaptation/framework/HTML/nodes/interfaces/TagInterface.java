package fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces;

import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBaseTag;

public class TagInterface implements SemanticsAdaptationInterface {
	private String tag;
	private List<HTMLNodeAttribute> attributes;
	
	public TagInterface(HTMLNodeBaseTag node) {
		tag = node.getTag();
		attributes = node.getAttributes();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<HTMLNodeAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<HTMLNodeAttribute> attributes) {
		this.attributes = attributes;
	}
}
