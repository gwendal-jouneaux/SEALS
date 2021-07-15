package fr.gjouneau.self.adaptation.framework.HTML.nodes.interfaces;

import java.util.List;

import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBase;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeBlockTag;

public class BlockTagInterface extends TagInterface {
	
	private List<HTMLNodeBase> children;

	public BlockTagInterface(HTMLNodeBlockTag node) {
		super(node);
		this.children = node.children();
	}

	public List<HTMLNodeBase> getChildren() {
		return children;
	}

	public void setChildren(List<HTMLNodeBase> children) {
		this.children = children;
	}

}
