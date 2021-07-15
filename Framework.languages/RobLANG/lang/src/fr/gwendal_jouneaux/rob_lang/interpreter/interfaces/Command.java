package fr.gwendal_jouneaux.rob_lang.interpreter.interfaces;

import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;

public interface Command {
	public void run(ContextRobLANG context);
}
