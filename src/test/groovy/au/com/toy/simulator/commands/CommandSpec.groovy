package au.com.toy.simulator.commands

import spock.lang.Specification
import spock.lang.Unroll

class CommandSpec extends Specification {

    @Unroll
    def 'these pattern should succeed: "#pattern"'() {
        when:
        def newCmd = ICommand.of(pattern)

        then:
        newCmd.isPresent()

        where:
        pattern               | _
        "place 90,100,North"  | _
        "place 9,9,SOUTH"     | _
        "Place 0,0,east"      | _
        "pLAcE 99,00,WeSt"    | _
        "MOVE"                | _
        "left"                | _
        "Right"               | _
        "REpOrT"              | _
    }

    @Unroll
    def 'these pattern should fail: "#pattern"'() {
        when:
        def newCmd = ICommand.of(pattern)

        then:
        !newCmd.isPresent()

        where:
        pattern                   | _
        "PLACED 0,0,NORTH"        | _
        "place 90,1010,NorthEast" | _
        "MOVED"                   | _
        "123"                     | _
        "REPORRTED"               | _
    }
}
