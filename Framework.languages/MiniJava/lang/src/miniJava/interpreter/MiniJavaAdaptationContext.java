package miniJava.interpreter;

import java.util.HashMap;
import java.util.Map;

import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.lang.adaptation.AdaptationContext;

public class MiniJavaAdaptationContext extends AdaptationContext<SelfAdaptiveMinJava> {

	@Override
	public Map<String, Double> readExpectedTradeOff() {
		Map<String, Double> out = new HashMap<String, Double>();
		out.put("Performance", Double.parseDouble(System.getenv("ADAPTABLE_PERFORMANCE")) / 100.0);
		out.put("Accuracy", Double.parseDouble(System.getenv("ADAPTABLE_ACCURACY")) / 100.0);
		return out;
	}

	@Override
	public String[] propertiesOfInterest() {
		return new String[] {"Performance", "Accuracy"};
	}

	@Override
	protected Resource[] environment() {
		return new Resource[] {new Resource("CPU_PERCENT")};
	}

}
