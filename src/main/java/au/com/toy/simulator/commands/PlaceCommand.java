package au.com.toy.simulator.commands;

import au.com.toy.simulator.model.EGeoDirection;
import au.com.toy.simulator.model.Position;
import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * Implements the PLACE command. Only this command doesnt require the
 * {@link ToyRobot} object to execute
 * 
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class PlaceCommand implements ICommand {

	public PlaceCommand(String cmdLine) {
		val args = cmdLine.split("[, ]");
		x = Integer.parseInt(args[1]);
		y = Integer.parseInt(args[2]);
		geoDirection = EGeoDirection.get(args[3]);
	}

	private int x, y;
	private EGeoDirection geoDirection;

	/**
	 * Place the {@link ToyRobot} on the {@link TableTop} in the given position
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		Position position = new Position(x, y);
		return tableTop.containsPosition(position)
				? ToyRobot.builder().position(position).facingDirection(geoDirection).build()
				: toyRobot;
	}

	/**
	 * Set it to FALSE as this command does not requires the {@link ToyRobot}
	 */
	@Override
	public boolean requiresToyRobot() {
		return false;
	}
}
