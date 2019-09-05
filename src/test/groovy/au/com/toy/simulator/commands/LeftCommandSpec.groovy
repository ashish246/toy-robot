package au.com.toy.simulator.commands

import static au.com.toy.simulator.model.EGeoDirection.WEST
import static au.com.toy.simulator.model.EGeoDirection.SOUTH

import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.ToyRobot
import spock.lang.Specification

class LeftCommandSpec extends Specification {

    def 'test command'() {
        given: 'a table top'
        def tableTop = new TableTop(7, 9)

        and: 'toy robot'
        def toyRobot = new ToyRobot(WEST, new Position(0, 0))

        when: 'toy robot is rotated'
        def rotated = new LeftCommand().execute(tableTop, toyRobot)

        then: 'direction is changed'
        rotated.facingDirection == SOUTH
    }
}
