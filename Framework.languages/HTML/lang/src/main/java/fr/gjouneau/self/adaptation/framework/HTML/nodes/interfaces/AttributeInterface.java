package fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces;

import fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeAttribute;

public class AttributeInterface implements SemanticsAdaptationInterface {
	
	private String value;
	
	public AttributeInterface(HTMLNodeAttribute node) {
		this.value = node.getValue();
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
