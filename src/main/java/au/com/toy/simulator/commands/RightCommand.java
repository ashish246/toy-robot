package au.com.toy.simulator.commands;

import static au.com.toy.simulator.model.ERotationDirection.RIGHT;

import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * A command to rotate {@link ToyRobot} to the RIGHT i.e. by 90 degrees
 *
 */
public class RightCommand implements ICommand {

	/**
	 * Rotates the {@link ToyRobot} by 90 degrees on the RIGHT side
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		return toyRobot.rotate(RIGHT);
	}
}
