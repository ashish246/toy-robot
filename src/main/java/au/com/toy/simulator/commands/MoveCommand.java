package au.com.toy.simulator.commands;

import au.com.toy.simulator.model.EGeoDirection;
import au.com.toy.simulator.model.Position;
import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * Implements the MOVE command in the facing direction
 *
 */
public class MoveCommand implements ICommand {

	/**
	 * Returns the {@link ToyRobot} of the new position after the MOVE if the new
	 * position is still on table top, else returns the old ToyRobot
	 */
	@Override
	public ToyRobot execute(TableTop tableTop, ToyRobot toyRobot) {
		Position currentPosition = toyRobot.getPosition();
		Position newPosition = move(currentPosition, toyRobot.getFacingDirection());
		return tableTop.containsPosition(newPosition)
				? ToyRobot.builder().position(newPosition).facingDirection(toyRobot.getFacingDirection()).build()
				: toyRobot;
	}

	/**
	 * @param position
	 * @param geoDirection
	 * @return the new {@link Position} after moving in the given facing direction
	 */
	private static Position move(Position position, EGeoDirection geoDirection) {
		int x = position.getX();
		int y = position.getY();

		switch (geoDirection) {
		case SOUTH:
			return new Position(x, --y);
		case WEST:
			return new Position(--x, y);
		case EAST:
			return new Position(++x, y);
		case NORTH:
			return new Position(x, ++y);
		default:
			return position;
		}
	}
}
