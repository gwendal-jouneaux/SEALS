package fr.gwendal_jouneaux.rob_lang.interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.gjouneau.savm.framework.decision.model.Bounds;
import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.lang.adaptation.AdaptationContext;
import fr.gwendal_jouneaux.rob_lang.typing.RobLANGTypeComputer;

public abstract class ContextRobLANG extends AdaptationContext<SelfAdaptableRobLANG> implements ExecutionContext {
	
	public final RobLANGTypeComputer typer = new RobLANGTypeComputer();
	
	@Override
	public Map<String, Double> readExpectedTradeOff() {
		Map<String, Double> out = new HashMap<String, Double>();
		String energyStr = "0.0";
		String speedStr = "0.0";
		try {
			String confFilePath = System.getenv("CONF_PATH");
			File confFile = new File(confFilePath);
			Scanner scanner = new Scanner(confFile);
			energyStr = scanner.nextLine();
			speedStr = scanner.nextLine();
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("An error occurred.");
			e.printStackTrace();
		}

		out.put("Energy", Double.parseDouble(energyStr) / 100.0);
		out.put("Time", Double.parseDouble(speedStr) / 100.0);
		return out;
	}

	@Override
	public String[] propertiesOfInterest() {
		return new String[] { "Energy", "Time" };
	}

	@Override
	protected Resource[] environment() {
		return new Resource[] { new Resource("Battery") };
	}
	
	// annotations
	abstract public void pushAdaptationBounds(String var, Bounds bounds);
	abstract public void popAdaptationBounds(String var);
	abstract public Map<String, Bounds> getAdaptationBounds();
}
