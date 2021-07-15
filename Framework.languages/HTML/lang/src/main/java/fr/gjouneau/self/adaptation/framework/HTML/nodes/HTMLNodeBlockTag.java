package fr.gjouneau.self.adaptation.framework.HTML.nodes;

import java.util.List;

import fr.gjouneau.savm.framework.lang.semantics.AdaptableNode;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces.BlockTagInterface;

public class HTMLNodeBlockTag extends HTMLNodeBaseTag implements AdaptableNode<BlockTagInterface>{
	
	private List<HTMLNodeBase> children;
	
	public HTMLNodeBlockTag(String tag, List<HTMLNodeAttribute> attributes, List<HTMLNodeBase> children) {
		super(tag, attributes);
		this.children = children;
	}

	public List<HTMLNodeBase> children() {
		return children;
	}

	public BlockTagInterface defaultInterface() {
		return new BlockTagInterface(this);
	}
}
