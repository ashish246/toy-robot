package au.com.toy.simulator.commands

import au.com.toy.simulator.model.TableTop
import au.com.toy.simulator.model.Position
import au.com.toy.simulator.model.ToyRobot
import spock.lang.Specification

import static au.com.toy.simulator.model.EGeoDirection.NORTH
import static au.com.toy.simulator.model.EGeoDirection.SOUTH

class PlaceCommandSpec extends Specification {

	def 'should update toy robot on successful placement'() {
		given: 'a table top'
		def tableTop = new TableTop(5, 5)

		and: 'toy robot'
		def toyRobot = new ToyRobot(NORTH, new Position(0, 0))

		when: 'command is executed'
		def command = new PlaceCommand(3, 3, SOUTH)
		def updated = command.execute(tableTop, toyRobot)

		then: 'toy robot is placed'
		updated.facingDirection == command.geoDirection
		updated.position.x == command.x
		updated.position.y == command.y
	}

	def 'should not update robot on placement failure'() {
		given: 'a table top'
		def tableTop = new TableTop(2, 2)

		and: 'toy robot'
		def toyRobot = new ToyRobot(NORTH, new Position(0, 0))

		when: 'command is failed to execute'
		def command = new PlaceCommand(-1, 1, SOUTH)
		def actual = command.execute(tableTop, toyRobot)

		then: 'toy robot is not placed'
		actual == toyRobot
	}
}
