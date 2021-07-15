package fr.gwendal_jouneaux.rob_lang.interpreter.interfaces;

import fr.gjouneau.savm.framework.lang.semantics.SemanticsAdaptationInterface;

public class MotorAdaptationInterface implements SemanticsAdaptationInterface {
	Command before;
	Command after;
	
	public Command getBefore() {
		return before;
	}

	public void setBefore(Command before) {
		this.before = before;
	}

	public Command getAfter() {
		return after;
	}

	public void setAfter(Command after) {
		this.after = after;
	}
}
