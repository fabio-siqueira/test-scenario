package dev.lecture.testscenario.repository

import dev.lecture.testscenario.domain.Payment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository extends CrudRepository<Payment, Long> {
}
