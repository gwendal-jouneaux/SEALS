package fr.gwendal_jouneaux.rob_lang.interpreter.adaptation.modules;

import fr.gwendal_jouneaux.rob_lang.interpreter.ContextRobLANG;
import fr.gwendal_jouneaux.rob_lang.interpreter.interfaces.Command;

public class ChangeSpeedCommand implements Command {
	private double speed;
	
	public ChangeSpeedCommand(double speed) {
		this.speed = speed;
	}

	@Override
	public void run(ContextRobLANG context) {
		context.setSpeed(speed);
	}

}
