package au.com.toy.simulator.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * This class holds the current position of {@link ToyRobot} with its X and Y
 * coordinates
 *
 */
@EqualsAndHashCode
@AllArgsConstructor
public class Position {

	@Getter
	private int x;

	@Getter
	private int y;

	@Override
	public String toString() {
		return x + "," + y;
	}
}
