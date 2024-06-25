package rw.ac.rca.bankManagement.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.bankManagement.v1.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByCustomerId(UUID customer_id);
    Optional<Customer> findByCustomerIdAndAccount(UUID customer_id, String account);


}
