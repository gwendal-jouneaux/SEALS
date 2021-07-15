package fr.gwendal_jouneaux.rob_lang;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import fr.gwendal_jouneaux.rob_lang.interpreter.SelfAdaptableRobLANG;
import fr.gwendal_jouneaux.rob_lang.robLANG.Robot;

public class App {
	public static void main(String[] args) {
		Injector injector = new RobLANGStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		
		String filePath = args[0];
		URI uri = URI.createFileURI(filePath);
		Resource resource = resourceSet.getResource(uri, true);
		
		SelfAdaptableRobLANG.initContext(new StandaloneContext());
		SelfAdaptableRobLANG lang = new SelfAdaptableRobLANG();

		Robot theRobot = (Robot) resource.getContents().get(0);

		System.out.println("Framework Program Started");
		Object out = theRobot.accept(lang.getVisitor(), lang.getAdaptationContext());
	}
}
