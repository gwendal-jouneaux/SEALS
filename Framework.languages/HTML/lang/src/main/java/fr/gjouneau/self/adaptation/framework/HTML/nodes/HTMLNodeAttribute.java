package fr.gjouneau.self.adaptation.framework.HTML.nodes;

import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.AttributeInterface;


public class HTMLNodeAttribute extends HTMLNodeBase implements AdaptableNode<AttributeInterface>{

	private final String name;
	private final String value;
	private final attributeType type;

	public enum attributeType {
		UNQUOTED, SIMPLE_QUOTED, DOUBLE_QUOTED
	}

	public HTMLNodeAttribute() {
		this.name = "";
		this.type = null;
		this.value = "";
	}
	
	public HTMLNodeAttribute(String name, String value, attributeType type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public attributeType getType() {
		return type;
	}

	@Override
	public AttributeInterface defaultInterface() {
		return new AttributeInterface(this);
	}

}
