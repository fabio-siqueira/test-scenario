package dev.lecture.testscenario.service

import org.springframework.stereotype.Component

import java.math.RoundingMode

@Component
class InstallmentCalculator {

    BigDecimal calcValue(BigDecimal value, Integer quantity) {
        value.divide(quantity, 2, RoundingMode.HALF_UP)
    }

}
