package au.com.toy.simulator.model;

import lombok.Builder;
import lombok.Getter;

/**
 * This class represents the table top with defined number of rows and columns
 *
 */
@Builder
public final class TableTop {

	@Getter
	private int rows;

	@Getter
	private int columns;

	/**
	 * @param position
	 * @return if the given position is on the table top or not. This is to check if
	 *         {@link ToyRobot} should move or not to avoid falling off
	 */
	public boolean containsPosition(Position position) {
		return position.getX() >= 0 && position.getX() < columns && position.getY() >= 0 && position.getY() < rows;
	}
}
