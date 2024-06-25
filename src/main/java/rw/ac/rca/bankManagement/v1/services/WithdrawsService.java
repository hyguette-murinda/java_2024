package rw.ac.rca.bankManagement.v1.services;

import org.springframework.stereotype.Service;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateWithdrawsDTO;
import rw.ac.rca.bankManagement.v1.models.Withdraws;

@Service
public interface WithdrawsService {
    Withdraws registerCustomerToWithdraw(CreateWithdrawsDTO createWithdrawsDTO) throws Exception;

}
