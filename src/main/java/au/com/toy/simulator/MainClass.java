package au.com.toy.simulator;

import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

import au.com.toy.simulator.commands.ICommand;
import au.com.toy.simulator.model.TableTop;
import au.com.toy.simulator.model.ToyRobot;
import lombok.val;

/**
 * The main class to start the program
 *
 */
public class MainClass {

	public static volatile boolean exit;

	public static void main(String[] args) {

		System.out.println("Toy Robot Simulator example...\n");
		System.out.println("Press Ctrl+C to exit...\n");

		try {
			// Create table top
			val settings = SimulatorProperties.getIntance();
			TableTop tableTop = TableTop.builder().rows(settings.getRowsCount().get())
					.columns(settings.getColumnsCount().get()).build();

			Optional<ToyRobot> toyRobot = Optional.empty();

			try (Scanner scanner = new Scanner(System.in)) {
				while (!exit) {
					System.out.print("cmd> ");
					String cmdLine = scanner.nextLine();
					Optional<ICommand> command = ICommand.of(cmdLine);

					if (!command.isPresent()) {
						System.out.print(format("%s is not a valid command. \n", cmdLine));
						continue;
					}

					/**
					 * Check if the Toy Robot is placed on table top. This ensures that no other
					 * commands can be executed unless PLACE command is executed to place the
					 * {@link ToyRobot} on the table top. It will return NULL if any of the MOVE,
					 * LEFT, RIGHT or REPORT command is executed before PLACE command after the
					 * start of the program
					 * 
					 */
					Optional<ToyRobot> newToyRobot = Optional.empty();
					if (toyRobot.isPresent() || !command.get().requiresToyRobot()) {
						newToyRobot = command.map(executeCommand(tableTop, toyRobot.orElse(null)));
					} else {
						System.out.print(format("%s is not a valid first command. \n", cmdLine));
					}

					toyRobot = newToyRobot.isPresent() ? newToyRobot : toyRobot;
				}
			}
		} catch (Exception e) {
			System.out.println(format("An exception occurred: %s", e.getMessage()));
		}

		// Add a shutdown hook to exit from the command panel
		getRuntime().addShutdownHook(new Thread(() -> exit = true));
	}

	/**
	 * @param tableTop
	 * @param toyRobot
	 * @return {@link ToyRobot} with new position and direction after the execution
	 *         of the command
	 */
	private static Function<ICommand, ToyRobot> executeCommand(TableTop tableTop, ToyRobot toyRobot) {
		return command -> command.execute(tableTop, toyRobot);
	}
}
