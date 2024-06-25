package rw.ac.rca.bankManagement.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.bankManagement.v1.models.Transfers;

import java.util.UUID;

public interface TransfersRepository extends JpaRepository<Transfers, UUID> {
}
