package dev.lecture.testscenario.service

import spock.lang.Specification
import spock.lang.Unroll

class InstallmentCalculatorTest extends Specification {

    InstallmentCalculator calculator
    
    void setup() {
        calculator = new InstallmentCalculator()
    }

    @Unroll
    def "should calc installment. value=#value installmentValue=#installmentValue"() {
        given:
            Integer installmentQuantity = 3

        when:
            BigDecimal result = calculator.calcValue(value as BigDecimal, installmentQuantity)

        then:
            result == installmentValue
            verifyResult(result, value, installmentQuantity)

        where:

            value   |   installmentValue
            55		|   18.33
            89		|   29.67
            144		|   48.00
            233		|   77.67
    }

    @Unroll
    def "same test. value=#value installmentValue=#installmentValue"() {
        setup:
            Integer installmentQuantity = 3

        expect:
            BigDecimal result = calculator.calcValue(value as BigDecimal, installmentQuantity)
            result == installmentValue
            verifyResult(result, value, installmentQuantity)

        where:
            value << [55, 89, 144, 233]
            installmentValue << [18.33,  29.67, 48.00, 77.67]
    }

    private static boolean verifyResult(BigDecimal result, BigDecimal value, Integer installmentQuantity) {
        (result * installmentQuantity - value) <= 0.01
    }
}
