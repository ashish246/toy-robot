package au.com.toy.simulator.model;

import static java.util.Arrays.stream;

import au.com.toy.simulator.exception.SimulatorException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum holds the geographical direction and their degree of angle w.r.t to
 * NORTH direction. So NORTH to NORTH is 360 degree and NORTH to WEST is 270
 * degree
 *
 */
@RequiredArgsConstructor
public enum EGeoDirection {
	NORTH(360), EAST(90), SOUTH(180), WEST(270);

	@Getter
	private final int degree;

	/**
	 * @param degree
	 * @return the {@link EGeoDirection} for the given degree and angleF
	 */
	public static EGeoDirection of(final int degree) {

		return stream(values()).filter(geoDirection -> geoDirection.getDegree() == degree).findFirst()
				.orElseThrow(() -> new SimulatorException("Geographical direction degree '%s' is invalid", degree));
	}

	/**
	 * @param word
	 * @return the {@link EGeoDirection} from the given direction
	 */
	public static EGeoDirection get(String word) {

		return stream(values()).filter(geoDirection -> geoDirection.name().equalsIgnoreCase(word)).findFirst()
				.orElseThrow(() -> new SimulatorException("Geographical direction '%s' is invalid", word));
	}
}
