package au.com.toy.simulator.model

import au.com.toy.simulator.exception.SimulatorException
import spock.lang.Specification
import spock.lang.Unroll

import static EGeoDirection.NORTH
import static EGeoDirection.EAST
import static EGeoDirection.WEST
import static EGeoDirection.SOUTH
import static ERotationDirection.LEFT

class GeoDirectionSpec extends Specification {

    def 'should throw exception parsing invalid direction'() {
        given: 'invalid direction pattern'
        def invalidPattern = 'ABBA'

        when: 'when converting'
        EGeoDirection.get(invalidPattern)

        then: 'exception is thrown'
        thrown SimulatorException
    }

    @Unroll
    def 'should get right direction: #pattern'() {
        expect: 'success'
        EGeoDirection.get(pattern) == expected

        where:
        pattern | expected
        'West'  | WEST
        'NORTH' | NORTH
        'south' | SOUTH
        'EAST'  | EAST
    }

    @Unroll
    def 'should correctly detect new direction: #degree'() {
        expect: 'success'
        EGeoDirection.of(degree) == direction

        where:
        direction | degree
        NORTH     | 360
        EAST      | 90
        SOUTH     | 180
        WEST      | 270
    }
}
