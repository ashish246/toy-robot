package au.com.toy.simulator.commands;

import java.util.function.Function;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Defines the possible patterns and their regex
 *
 */
@RequiredArgsConstructor
public enum ECommandPatterns {

	PLACE("(?i)PLACE (-?\\d+),(-?\\d+),(WEST|NORTH|SOUTH|EAST)$", s -> new PlaceCommand(s)),
	MOVE("(?i)MOVE$", s -> new MoveCommand()), 
	LEFT("(?i)LEFT$", s -> new LeftCommand()),
	RIGHT("(?i)RIGHT$", s -> new RightCommand()), 
	REPORT("(?i)REPORT$", s -> new ReportCommand()),
	EXIT("(?i)EXIT$", s -> new ExitCommand());

	@Getter
	private final String regex;

	@Getter
	private final Function<String, ICommand> create;
}
