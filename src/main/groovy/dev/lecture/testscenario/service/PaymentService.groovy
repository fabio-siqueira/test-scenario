package dev.lecture.testscenario.service

import dev.lecture.testscenario.domain.Payment
import dev.lecture.testscenario.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService {

    @Autowired
    PaymentRepository paymentRepository

    @Autowired
    InstallmentCalculator installmentCalculator

    Payment create(Payment payment) {
        paymentRepository.save(payment.with {
           installmentValue = calcInstallmentValue(value, installmentQuantity)
           it
        })
    }

    private BigDecimal calcInstallmentValue(BigDecimal value, Integer quantity) {
        installmentCalculator.calcValue(value, quantity)
    }
}
