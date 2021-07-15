package fr.gjouneau.selfadaptable_minijava.lang.visitor.execute;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import miniJava.interpreter.SelfAdaptiveMinJava;
import miniJava.interpreter.dynamicModules.ApproximateModule;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Program;

public class App {
   
    public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.exit(1);
		}
		SelfAdaptiveMinJava lang = new SelfAdaptiveMinJava();
		lang.getAdaptationContext().registerModule(new ApproximateModule());

		Program root = loadXMI(args[0]);

		Object out = root.accept(lang.getVisitor(), null);
	}
    
    public static Program loadXMI(String path) {
		EPackage.Registry.INSTANCE.put("http://miniJava.miniJava.miniJava/", MiniJavaPackage.eINSTANCE);
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		LogService.MUTE = false;

		final ResourceSetImpl resSet = new ResourceSetImpl();
		final URI createFileURI = URI.createFileURI(path);
		final Resource resource = resSet.getResource(createFileURI, true);

		Program minijavaProgram = (Program) resource.getContents().get(0);
		// convert Ecore AST to the framework AST
		
		minijavaProgram.initialize(new BasicEList());
		return minijavaProgram;
	}
}
