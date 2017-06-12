package dev.lecture.testscenario.service

import dev.lecture.testscenario.domain.Payment
import dev.lecture.testscenario.repository.PaymentRepository
import spock.lang.Specification

class PaymentServiceTest extends Specification {

    PaymentService service
    PaymentRepository paymentRepositoryMock
    InstallmentCalculator installmentCalculatorMock

    void setup() {
        paymentRepositoryMock = Mock(PaymentRepository)
        installmentCalculatorMock = Mock(InstallmentCalculator)

        service = new PaymentService(
                paymentRepository: paymentRepositoryMock,
                installmentCalculator: installmentCalculatorMock
        )
    }

    def "should create a payment"() {
        given: 'a payment'
            Payment payment = new Payment(
                    value: 150,
                    installmentQuantity: 3
            )

        and: 'a installment value'
            BigDecimal installmentValue = 50

        and: 'payment id'
            Long paymentId = 1L

        when:
            Payment result = service.create(payment)

        then:
            result

            1 * installmentCalculatorMock.calcValue(payment.value, payment.installmentQuantity) >> installmentValue

            1 * paymentRepositoryMock.save(_) >> { Payment payment1 ->
                assert payment1.installmentValue == installmentValue

                payment.with {
                    id = paymentId
                    it
                }
            }

    }
}
