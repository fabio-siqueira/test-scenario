package dev.lecture.testscenario.extensions

import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class StepwiseTest extends Specification{

    def "first"() {
        when:
            println('first')
        then:
            true
    }

    def "second"() {
        when:
            println('second')
        then:
            true
    }

    def "third"() {
        when:
            println('third')
        then:
            true
    }
}
