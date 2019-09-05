package au.com.toy.simulator.exception;

import static java.lang.String.format;

/**
 * This class captures the exception occurred for loading any configurations
 *
 */
public class ConfigurationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConfigurationException(String error, Object... args) {
		super(format(error, args));
	}

}
