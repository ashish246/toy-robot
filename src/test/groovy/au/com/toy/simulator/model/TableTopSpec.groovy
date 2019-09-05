package au.com.toy.simulator.model

import au.com.toy.simulator.model.Position

import au.com.toy.simulator.model.TableTop
import spock.lang.Specification
import spock.lang.Unroll

class TableTopSpec extends Specification {

    @Unroll
    def 'test can place: (#position)'() {
        given: 'a tableTop'
        def tableTop = new TableTop(5, 5)

        expect: 'a valid coordinates'
        tableTop.containsPosition(position)

        where:
        position           | _
        new Position(0, 0) | _
        new Position(4, 4) | _
        new Position(0, 3) | _
    }

    @Unroll
    def 'test cannot place: (#position)'() {
        given: 'a tableTop'
        def tableTop = new TableTop(5, 5)

        expect: 'invalid coordinates'
        !tableTop.containsPosition(position)

        where:
        position             | _
        new Position(-1, -1) | _
        new Position(5, 5)   | _
        new Position(9, 0)   | _
    }

	def 'test custom table top size' (){
		given: 'a table top with custom'
		def newRow = 7
		def newColumn = 6
		
		when: 'table top is build'
		def tableTop = TableTop.builder().columns(newColumn).rows(newRow).build()
		
		then: 'table top has specified new columns and rows'
		tableTop.columns == newColumn && tableTop.rows == newRow
	}
}
