package au.com.toy.simulator.model

import static au.com.toy.simulator.model.ERotationDirection.*
import static au.com.toy.simulator.model.EGeoDirection.*

import spock.lang.Specification
import spock.lang.Unroll

class ToyRobotSpec extends Specification {

    def 'test toy robot toString()'() {
        given: 'a toy robot'
        def toyRobot = ToyRobot.builder()
                .facingDirection(EAST)
                .position(new Position(1, 2))
                .build()

        expect: 'x, y and direction to be included in the string'
        toyRobot.toString() == "${toyRobot.position.x},${toyRobot.position.y},${toyRobot.facingDirection}"
    }

    @Unroll
    def 'test toy robot rotation to the left: #initial -> #expected'() {
        given: 'a robot'
        def origin = new ToyRobot(initial, new Position(0, 0))

        when: 'I rotate the toy robot'
        def rotated = origin.rotate(LEFT)

        then: 'toy robot is facing correct direction'
        rotated.facingDirection == expected

        and: 'position remains the same'
        origin.position == rotated.position

        where:
        initial | expected
        NORTH   | WEST
        WEST    | SOUTH
        SOUTH   | EAST
        EAST    | NORTH
    }

    @Unroll
    def 'test toy robot rotation to the right: #initial -> #expected'() {
        given: 'a toy robot'
        def origin = new ToyRobot(initial, new Position(3, 3))

        when: 'I rotate the toy robot'
        def rotated = origin.rotate(RIGHT)

        then: 'toy robot is facing correct direction'
        rotated.facingDirection == expected

        and: 'position remains the same'
        origin.position == rotated.position

        where:
        initial | expected
        NORTH   | EAST
        EAST    | SOUTH
        SOUTH   | WEST
        WEST    | NORTH
    }
}
