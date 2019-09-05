package au.com.toy.simulator.commands;

import static au.com.toy.simulator.model.ERotationDirection.LEFT;

import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * A command to rotate {@link ToyRobot} to the LEFT i.e. by -90 degrees
 *
 */
public class LeftCommand implements ICommand {

	/**
	 * Rotates the {@link ToyRobot} by 90 degrees on the LEFT side
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		return toyRobot.rotate(LEFT);
	}
}
