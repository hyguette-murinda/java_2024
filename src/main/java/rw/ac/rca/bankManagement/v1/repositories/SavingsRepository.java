package rw.ac.rca.bankManagement.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca.bankManagement.v1.models.Savings;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, UUID> {
    Optional<Savings> findByCustomerIdAndAccount(UUID customer_id, String account);
}
