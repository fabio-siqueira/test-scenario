
CREATE TABLE payment
(
    id SERIAL PRIMARY KEY,
    _value FLOAT NOT NULL,
    installment_value INTEGER NOT NULL,
    installment_quantity INTEGER NOT NULL
);