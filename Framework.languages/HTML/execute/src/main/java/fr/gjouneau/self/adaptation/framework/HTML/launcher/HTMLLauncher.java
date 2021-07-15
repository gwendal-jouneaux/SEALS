package fr.gjouneau.self.adaptation.framework.HTML.launcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import fr.gjouneau.self.adaptation.framework.HTML.HTMLParser;
import fr.gjouneau.self.adaptation.framework.HTML.SelfAdaptiveHTML;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot;

public final class HTMLLauncher {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.exit(1);
		}
		SelfAdaptiveHTML lang = new SelfAdaptiveHTML();

		String source = readFile(args[0]);
		HTMLParser parser = new HTMLParser(source);
		HTMLNodeRoot root = parser.parse();

		Object out = root.accept(lang.getVisitor(), null);
		System.out.println(out);
	}

	private static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}
}