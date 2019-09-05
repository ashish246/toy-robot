package au.com.toy.simulator.commands

import static au.com.toy.simulator.model.EGeoDirection.EAST
import static au.com.toy.simulator.model.EGeoDirection.NORTH
import static au.com.toy.simulator.model.EGeoDirection.SOUTH
import static au.com.toy.simulator.model.EGeoDirection.WEST

import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.ToyRobot
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MoveCommandSpec extends Specification {

    @Shared
    def moveCmd = new MoveCommand()

    @Unroll
    def 'test moves: "#robot"'() {
        given: 'a table top'
        def tableTop = new TableTop(3, 3)

        when: 'command is executed'
        def moved = moveCmd.execute(tableTop, robot)

        then: 'toy robot is moved correctly'
        moved.position == expected

        where:
        robot                      					| expected
        new ToyRobot(SOUTH, new Position(1, 1)) 	| new Position(1, 0)
        new ToyRobot(WEST, new Position(1, 1)) 		| new Position(0, 1)
        new ToyRobot(EAST, new Position(1, 1)) 		| new Position(2, 1)
        new ToyRobot(NORTH, new Position(1, 1)) 	| new Position(1, 2)
    }

    def 'should prevent toy robot from falling off the table'() {
        given: 'a tabletop'
        def tableTop = new TableTop(3, 3)

        and: 'toy robot in the south west corner'
        def toyRobot = new ToyRobot(SOUTH, new Position(0, 0))

        when: 'command is executed'
        def actual = moveCmd.execute(tableTop, toyRobot)

        then: 'position of the toy robot will remain the same'
        actual.position == toyRobot.position
    }
}
