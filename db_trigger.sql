CREATE TABLE Message (
                         id SERIAL PRIMARY KEY,
                         customer VARCHAR(255),
                         message TEXT,
                         dateTime TIMESTAMP
);

CREATE OR REPLACE FUNCTION after_transaction_insert()
    RETURNS TRIGGER AS $$
BEGIN
    DECLARE
        customer_name VARCHAR(255);
    BEGIN
        SELECT CONCAT(first_name, ' ', last_name) INTO customer_name
        FROM customers
        WHERE customer_id = customers.customer_id;

        INSERT INTO Message (customer, message, dateTime)
        VALUES (customer_name, CONCAT('Transaction completed: ', NEW.amount), NOW());

        RETURN NEW;
    END;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_transaction_insert_trigger
    AFTER INSERT ON savings
    FOR EACH ROW
EXECUTE FUNCTION after_transaction_insert();
