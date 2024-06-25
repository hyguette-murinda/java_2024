package rw.ac.rca.bankManagement.v1.services;

import org.springframework.stereotype.Service;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateSavingsDTO;
import rw.ac.rca.bankManagement.v1.models.Savings;

@Service
public interface SavingsService {
    Savings registerCustomerToSaving(CreateSavingsDTO createSavingsDTO) throws Exception;

}
