package au.com.toy.simulator

import au.com.toy.simulator.commands.ICommand
import au.com.toy.simulator.model.EGeoDirection
import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.ToyRobot
import spock.lang.Specification

class HappyPath extends Specification {

    def 'happy path'() {
        given: 'a pre-requisites'
        TableTop tableTop = new TableTop(5, 5)
        Optional<ToyRobot> newToyRobot = Optional.empty()

        when: 'I run commands'
        newToyRobot = executeCommand("PLACE 1,2,WEST", tableTop, newToyRobot)
        newToyRobot = executeCommand("MOVE", tableTop, newToyRobot)
        newToyRobot = executeCommand("MOVE", tableTop, newToyRobot)
        newToyRobot = executeCommand("LEFT", tableTop, newToyRobot)
        newToyRobot = executeCommand("MOVE", tableTop, newToyRobot)

        then: 'I get correct result'
        def toyRobot = newToyRobot.get()

        toyRobot.position == new Position(0,1)
        toyRobot.facingDirection == EGeoDirection.SOUTH
    }

    def executeCommand(cmdLine, tableTop, newToyRobot) {
        return ICommand.of(cmdLine).map { it.execute(tableTop, newToyRobot.orElse(null)) }
    }
}
