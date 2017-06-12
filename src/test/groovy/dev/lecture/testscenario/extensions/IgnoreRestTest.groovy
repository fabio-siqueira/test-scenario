package dev.lecture.testscenario.extensions

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

class IgnoreRestTest extends Specification {

    @IgnoreRest
    def 'ignore all but this' () {
        when:
            println("it won't be executed")

        then:
            true

    }

    def 'ignored with ignore rest' () {
        when:
        println("it won't be executed")

        then:
        true

    }
}
