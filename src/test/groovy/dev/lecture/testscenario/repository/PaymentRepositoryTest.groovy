package dev.lecture.testscenario.repository

import dev.lecture.testscenario.ApplicationTests
import dev.lecture.testscenario.domain.Payment
import org.springframework.beans.factory.annotation.Autowired

class PaymentRepositoryTest extends ApplicationTests {

    @Autowired
    PaymentRepository repository

    void setup() {
    }

    void cleanup() {
        repository.deleteAll() // ponto de atenção
    }


    def "should save a payment"() {
        given:
            Payment payment = new Payment(
                    installmentQuantity: 2,
                    value: new BigDecimal(20),
                    installmentValue: new BigDecimal(10)
            )

        when:
            repository.save(payment)

        then:
            payment.id
    }

    def "should retrieve a payment"() {
        given:
            Payment payment = repository.save(new Payment(
                    installmentQuantity: 2,
                    value: new BigDecimal(20),
                    installmentValue: new BigDecimal(10)
            ))

        when:
            Payment result = repository.findOne(payment.id)

        then:
            result
            result.value == payment.value
            result.installmentValue == payment.installmentValue
            result.installmentQuantity == payment.installmentQuantity
    }
}
