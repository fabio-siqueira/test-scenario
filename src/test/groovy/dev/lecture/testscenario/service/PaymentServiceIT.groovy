package dev.lecture.testscenario.service

import dev.lecture.testscenario.ApplicationTests
import dev.lecture.testscenario.domain.Payment
import org.springframework.beans.factory.annotation.Autowired

class PaymentServiceIT extends ApplicationTests {

    @Autowired
    PaymentService service

    def 'should create a payment with calculated installment value'() {

        given: 'a payment without installment value'
            Payment payment = new Payment(
                    value: 512,
                    installmentQuantity: 5
            )

        when:
            Payment result = service.create(payment)

        then:
            result.installmentValue
    }
}
