	package fr.gjouneau.self.adaptation.framework.HTML.nodes;

public class HTMLNodeRoot extends HTMLNodeBase{

	
	private HTMLNodeBase html;

	public HTMLNodeRoot(HTMLNodeBlockTag html) {
		this.html = html;
	}

	public HTMLNodeBase getHtml() {
		return html;
	}
}
