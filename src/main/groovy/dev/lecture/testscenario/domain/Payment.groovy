package dev.lecture.testscenario.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

import static javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = 'payment')
class Payment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id

    @NotNull
    @Column(name = '_value')
    BigDecimal value

    @NotNull
    @Column(name = 'installment_value')
    BigDecimal installmentValue

    @NotNull
    @Column(name = 'installment_quantity')
    Integer installmentQuantity

}
