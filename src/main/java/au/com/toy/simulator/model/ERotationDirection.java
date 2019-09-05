package au.com.toy.simulator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum holds the two possible rotation direction i.e. LEFT and RIGHT and
 * their respective rotation angles i.e. 90 and -90 degrees w.r.t. the facing
 * direction
 *
 */
@RequiredArgsConstructor
public enum ERotationDirection {
	LEFT(-90), RIGHT(90);

	@Getter
	private final int angle;
}
