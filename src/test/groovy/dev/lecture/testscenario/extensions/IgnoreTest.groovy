package dev.lecture.testscenario.extensions

import spock.lang.Ignore
import spock.lang.Specification

//@Ignore // ignore all tests
class IgnoreTest extends Specification {

    @Ignore
    def 'ignored' () {
        when:
            println("it won't be executed")

        then:
            true

    }

    @Ignore('TODO: refactor this test')
    def 'ignored with documentation' () {
        when:
        println("it won't be executed")

        then:
        true

    }
}
