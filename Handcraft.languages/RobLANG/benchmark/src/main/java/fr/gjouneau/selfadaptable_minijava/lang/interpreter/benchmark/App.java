package fr.gjouneau.selfadaptable_minijava.lang.interpreter.benchmark;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
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

import com.google.inject.Injector;

import fr.gwendal_jouneaux.rob_lang.RobLANGStandaloneSetupGenerated;
import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.FeedbackLoop;
import fr.gwendal_jouneaux.rob_lang.interpreter.InterpretRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.adaptation.modules.BatteryOptimization;
import fr.gwendal_jouneaux.rob_lang.robLANG.Robot;


@State(Scope.Benchmark)
public class App 
{
	@Param({"../programs/program.rob"})
	public String program;
	private Robot theRobot;
	private ContextRobLANG context;
    
    @Setup(Level.Iteration)
    public void loadXMI() {
    	Injector injector = new RobLANGStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		String filePath = program;
		URI uri = URI.createFileURI(filePath);
		Resource resource = resourceSet.getResource(uri, true);
		
		context = new StandaloneContext();
		FeedbackLoop.INSTANCE().setContext(context);
		FeedbackLoop.INSTANCE().registerModule(new BatteryOptimization());

		theRobot = (Robot) resource.getContents().get(0);
	}
    
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 30)
    @Fork(value = 1, jvmArgs = {"-Xms4G", "-Xmx4G"})
    @Warmup(iterations = 10)
    public Object robLangInterpreter() {

        return InterpretRobLANG.INSTANCE().interpret(theRobot, context);
    }
}
