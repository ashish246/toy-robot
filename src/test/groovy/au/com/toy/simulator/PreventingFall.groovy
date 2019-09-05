package au.com.toy.simulator

import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.ToyRobot
import au.com.toy.simulator.commands.ICommand
import spock.lang.Specification

class PreventingFall extends Specification {

    def 'saving robot'() {
        given: 'a prerequisites'
        TableTop tableTop = new TableTop(5, 5)
        Optional<ToyRobot> newToyRobot = Optional.empty()

        when: 'I run commands'
        newToyRobot = executeCommand("PLACE 0,0,EAST", tableTop, newToyRobot)
        newToyRobot = executeCommand("MOVE", tableTop, newToyRobot)
        newToyRobot = executeCommand("RIGHT", tableTop, newToyRobot)
        newToyRobot = executeCommand("MOVE", tableTop, newToyRobot)

        then: 'robot must stay on board'
        def toyRobot = newToyRobot.get()
        toyRobot.position == new Position(1,0)
    }

    def executeCommand(cmdLine, tableTop, newToyRobot) {
        return ICommand.of(cmdLine).map { it.execute(tableTop, newToyRobot.orElse(null)) }
    }
}
