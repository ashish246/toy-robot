package au.com.toy.simulator.model;

import static java.lang.String.format;
import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * This class represent the toy robot and contains the method to give its
 * current position and rotating itself to the given {@link ERotationDirection}
 *
 */
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Builder
public class ToyRobot {

	@Getter
	private EGeoDirection facingDirection;

	@Getter
	private Position position;

	/**
	 * @param rotation
	 * @return the {@link ToyRobot} of the new position after rotation
	 */
	public ToyRobot rotate(ERotationDirection rotation) {
		// Get the final degree of angle after the rotation and get the remainder of 360
		val newDegree = (facingDirection.getDegree() + rotation.getAngle()) % 360;

		val geoDirection = EGeoDirection.of(newDegree == 0 ? 360 : newDegree);
		return ToyRobot.builder().facingDirection(geoDirection).position(position).build();
	}

	@Override
	public String toString() {
		return format("%s,%s", position, facingDirection);
	}

}
