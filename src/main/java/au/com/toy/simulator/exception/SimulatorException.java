package au.com.toy.simulator.exception;

import static java.lang.String.format;

/**
 * This class captures the exception occurred while simulation the actions for
 * toy robot
 *
 */
public class SimulatorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulatorException(String error, Object... args) {
		super(format(error, args));
	}
}
