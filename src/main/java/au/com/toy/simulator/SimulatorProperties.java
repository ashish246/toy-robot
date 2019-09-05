package au.com.toy.simulator;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import au.com.toy.simulator.exception.ConfigurationException;

/**
 * This class loads all the properties and configurations
 */
public final class SimulatorProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PROPERTIES_FILE = "application.properties";
	private static final String TABLETOP_ROWS = "tabletop.rows";
	private static final String TABLETOP_COLUMNS = "tabletop.columns";

	private SimulatorProperties() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			try (InputStream stream = classLoader.getResourceAsStream(PROPERTIES_FILE)) {
				this.load(stream);
			}
		} catch (Exception e) {
			throw new ConfigurationException("Cannot load configurations: %s", e.getMessage());
		}
	}

	/**
	 * @return the total count of rows defined in the property tabletop.rows
	 */
	public Optional<Integer> getRowsCount() {
		return Optional.ofNullable(getProperty(TABLETOP_ROWS)).map(Integer::parseInt);
	}

	/**
	 * @return the total count of columns defined in the property tabletop.columns
	 */
	public Optional<Integer> getColumnsCount() {
		return Optional.ofNullable(getProperty(TABLETOP_COLUMNS)).map(Integer::parseInt);
	}

	/**
	 * @return the instance of {@link SimulatorProperties}
	 */
	public static SimulatorProperties getIntance() {
		return new SimulatorProperties();
	}
}
