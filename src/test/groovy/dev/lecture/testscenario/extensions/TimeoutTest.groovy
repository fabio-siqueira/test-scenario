package dev.lecture.testscenario.extensions

import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

class TimeoutTest extends Specification {

    @Timeout(value = 1000, unit=TimeUnit.MILLISECONDS)
    def "timeout test"() {
        when:
            Thread.sleep(900)

        then:
            true
    }
}
