package au.com.toy.simulator.commands;

import au.com.toy.simulator.MainClass;
import au.com.toy.simulator.model.Position;
import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * A command to report the current {@link Position} and {@link GeoDirection} of
 * the {@link ToyRobot}
 * 
 */
public class ExitCommand implements ICommand {

	/**
	 * Logs the current position and facing direction of the {@link ToyRobot}
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		// Add a shutdown hook to exit from the command panel
		MainClass.exit = true;
		return toyRobot;
	}

	/**
	 * Set it to FALSE as this command does not requires the {@link ToyRobot}
	 */
	@Override
	public boolean requiresToyRobot() {
		return false;
	}
}
