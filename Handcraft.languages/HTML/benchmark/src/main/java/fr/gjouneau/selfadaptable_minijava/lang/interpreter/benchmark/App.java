package fr.gjouneau.selfadaptable_minijava.lang.interpreter.benchmark;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
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


@State(Scope.Benchmark)
public class App 
{
	@Param({"../programs/wikipedia.html"})
	public String program;
	private Context context;
	private Source source;
	
	private static final String HTML = "HTML";
    
    @Setup(Level.Iteration)
    public void load() throws IOException {
        Map<String, String> options = new HashMap<String, String>();

        if (program == null) {
            // @formatter:off
            source = Source.newBuilder(HTML, new InputStreamReader(System.in), "<stdin>").build();
            // @formatter:on
        } else {
            source = Source.newBuilder(HTML, new File(program)).build();
        }

        context = null;
        PrintStream err = System.err;
        try {
            context = Context.newBuilder(HTML).in(System.in).out(System.out).options(options).build();
        } catch (IllegalArgumentException e) {
            err.println(e.getMessage());
        }
        //out.println("== running on " + context.getEngine());

        try {
            Value result = context.eval(source);
            if (!result.isNull()) {
            	System.out.println(result.toString());
            }
        } catch (PolyglotException ex) {
            if (ex.isInternalError()) {
                // for internal errors we print the full stack trace
                ex.printStackTrace();
            } else {
                err.println(ex.getMessage());
            }
        } finally {
            context.close();
        }
	}
    
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 30)
    @Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx4G"})
    @Warmup(iterations = 10)
    public Value htmlInterpreter() {
		try {
            Value result = context.eval(source);
            if (!result.isNull()) {
            	System.out.println(result.toString());
            }
            return result;
        } catch (PolyglotException ex) {
            if (ex.isInternalError()) {
                // for internal errors we print the full stack trace
                ex.printStackTrace();
            } else {
                System.err.println(ex.getMessage());
            }
            return null;
        } finally {
            context.close();
        }
    }
}
