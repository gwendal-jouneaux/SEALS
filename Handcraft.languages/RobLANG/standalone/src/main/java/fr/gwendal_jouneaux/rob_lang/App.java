package fr.gwendal_jouneaux.rob_lang;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import fr.gwendal_jouneaux.rob_lang.interpreter.FeedbackLoop;
import fr.gwendal_jouneaux.rob_lang.interpreter.InterpretRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.adaptation.modules.BatteryOptimization;
import fr.gwendal_jouneaux.rob_lang.robLANG.Robot;

public class App {
	public static void main(String[] args) {
		Injector injector = new RobLANGStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		String filePath = args[0];
		URI uri = URI.createFileURI(filePath);
		Resource resource = resourceSet.getResource(uri, true);
		
		StandaloneContext context = new StandaloneContext();
		FeedbackLoop.INSTANCE().setContext(context);
		//FeedbackLoop.INSTANCE().registerModule(new BatteryOptimization());

		Robot theRobot = (Robot) resource.getContents().get(0);
		Object out = InterpretRobLANG.INSTANCE().interpret(theRobot, context);
		System.out.println(out);
	}
}
