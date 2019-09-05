package au.com.toy.simulator.commands;

import static java.util.Arrays.stream;

import java.util.Optional;
import java.util.regex.Pattern;

import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;

/**
 * Interface for all the commands
 */
public interface ICommand {

	/**
	 * @param tableTop
	 * @param toyRobot
	 * @return
	 */
	ToyRobot execute(TableTop tableTop, ToyRobot toyRobot);

	/**
	 * By default, all the commands should require the {@link ToyRobot} to execute
	 * them except the PLACE command
	 * 
	 * @return
	 */
	default boolean requiresToyRobot() {
		return true;
	}

	/**
	 * @param line
	 * @return the {@link ICommand} which matches the input provided by the command
	 *         prompt
	 */
	static Optional<ICommand> of(String line) {
		return stream(ECommandPatterns.values())
				.filter(cmdPattern -> Pattern.compile(cmdPattern.getRegex()).matcher(line).matches()).findFirst()
				.map(command -> command.getCreate().apply(line));
	}
}
