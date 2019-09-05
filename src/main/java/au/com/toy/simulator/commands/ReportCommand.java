package au.com.toy.simulator.commands;

import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * A command to report the current {@link Position} and {@link GeoDirection} of
 * the {@link ToyRobot}
 * 
 */
public class ReportCommand implements ICommand {

	/**
	 * Logs the current position and facing direction of the {@link ToyRobot}
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		System.out.println(toyRobot);
		return toyRobot;
	}
}
