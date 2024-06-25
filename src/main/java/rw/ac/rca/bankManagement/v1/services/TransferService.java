package rw.ac.rca.bankManagement.v1.services;

import rw.ac.rca.bankManagement.v1.dto.requests.CreateTransfersDTO;
import rw.ac.rca.bankManagement.v1.models.Customer;

public interface TransferService {
    void transferAmount(CreateTransfersDTO createTransferDTO) throws Exception;
}

