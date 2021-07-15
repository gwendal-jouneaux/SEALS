package fr.gjouneau.self.adaptation.framework.HTML.nodes;

import java.util.List;

public abstract class HTMLNodeBaseTag extends HTMLNodeBase{

	private final String tag;
	private List<HTMLNodeAttribute> attributes;
	
	public HTMLNodeBaseTag(String tag, List<HTMLNodeAttribute> attributes) {
		this.tag = tag;
		this.attributes = attributes;
	}

	public String getTag() {
		return tag;
	}

	public List<HTMLNodeAttribute> getAttributes() {
		return attributes;
	}
	
	
}
