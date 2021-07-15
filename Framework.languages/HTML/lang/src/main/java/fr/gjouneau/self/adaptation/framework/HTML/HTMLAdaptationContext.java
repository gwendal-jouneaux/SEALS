package fr.gjouneau.self.adaptation.framework.HTML;

import java.util.HashMap;
import java.util.Map;

import fr.gjouneau.savm.framework.decision.model.Resource;
import fr.gjouneau.savm.framework.lang.adaptation.AdaptationContext;

public class HTMLAdaptationContext extends AdaptationContext<SelfAdaptiveHTML> {

	@Override
	public Map<String, Double> readExpectedTradeOff() {
		Map<String, Double> out = new HashMap<String, Double>();
		out.put("Energy", Double.parseDouble(System.getenv("ADAPTABLE_HTML_ENERGY")) / 100.0);
		out.put("Accuracy", Double.parseDouble(System.getenv("ADAPTABLE_HTML_ACCURACY")) / 100.0);
		return out;
	}

	@Override
	public String[] propertiesOfInterest() {
		return new String[] {"Energy", "Accuracy"};
	}

	@Override
	protected Resource[] environment() {
		return new Resource[] {};
	}

}
