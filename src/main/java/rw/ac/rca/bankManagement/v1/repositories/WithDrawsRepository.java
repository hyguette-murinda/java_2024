package rw.ac.rca.bankManagement.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.bankManagement.v1.models.Savings;
import rw.ac.rca.bankManagement.v1.models.Withdraws;

import java.util.Optional;
import java.util.UUID;

public interface WithDrawsRepository extends JpaRepository<Withdraws, UUID> {
    Optional<Savings> findByCustomerIdAndAccount(UUID customer_id, String account);
}
