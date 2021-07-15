package fr.gjouneau.selfadaptable_minijava.lang.interpreter.benchmark;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import fr.gjouneau.self.adaptation.framework.HTML.HTMLParser;
import fr.gjouneau.self.adaptation.framework.HTML.SelfAdaptiveHTML;
import fr.gjouneau.self.adaptation.framework.HTML.nodes.HTMLNodeRoot;


@State(Scope.Benchmark)
public class App 
{
	@Param({"../programs/wikipedia.html"})
	public String program;
	private HTMLNodeRoot root;
	private SelfAdaptiveHTML lang;
    
    @Setup(Level.Iteration)
    public void load() {
		SelfAdaptiveHTML lang = new SelfAdaptiveHTML();

		String source = "";
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(program));
			source = new String(encoded);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HTMLParser parser = new HTMLParser(source);
		HTMLNodeRoot root = parser.parse();
	}
    
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 30)
    @Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx4G"})
    @Warmup(iterations = 10)
    public Object htmlInterpreter() {

        return root.accept(lang.getVisitor(), null);
    }
}
