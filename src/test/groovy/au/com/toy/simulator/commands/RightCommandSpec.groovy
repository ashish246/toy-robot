package au.com.toy.simulator.commands

import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.ToyRobot
import spock.lang.Specification

import static au.com.toy.simulator.model.EGeoDirection.EAST
import static au.com.toy.simulator.model.EGeoDirection.NORTH

class RightCommandSpec extends Specification {

    def 'test command'() {
        given: 'a table top'
        def tableTop = new TableTop(7, 9)

        and: 'toy robot'
        def toyRobot = new ToyRobot(NORTH, new Position(0, 0))

        when: 'toy robot is rotated'
        def rotated = new RightCommand().execute(tableTop, toyRobot)

        then: 'direction is changed'
        rotated.facingDirection == EAST
    }
}
