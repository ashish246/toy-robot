package au.com.toy.simulator

import spock.lang.Specification

class SimulatorPropertiesSpec extends Specification {

    def 'should read rows count'() {
        when: 'properties are read'
        def properties = SimulatorProperties.getIntance()

        then: 'rows count present'
        properties.getRowsCount().isPresent()
    }

    def 'should read columns count'() {
        when: 'properties are read'
        def properties = SimulatorProperties.getIntance()

        then: 'columns count present'
        properties.getColumnsCount().get() == 5
    }
}
