package fr.gjouneau.self.adaptation.framework.HTML.nodes;

public class HTMLNodePlainText extends HTMLNodeBase {
	
	private final String content;

	public HTMLNodePlainText(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;	
	}
}
