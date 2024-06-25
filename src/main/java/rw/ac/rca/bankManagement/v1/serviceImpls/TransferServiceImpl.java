package rw.ac.rca.bankManagement.v1.serviceImpls;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateTransfersDTO;
import rw.ac.rca.bankManagement.v1.enums.Type;
import rw.ac.rca.bankManagement.v1.models.Customer;
import rw.ac.rca.bankManagement.v1.repositories.CustomerRepository;
import rw.ac.rca.bankManagement.v1.services.MailService;
import rw.ac.rca.bankManagement.v1.services.TransferService;

import java.util.Optional;

@Service

public class TransferServiceImpl implements TransferService {

    private final CustomerRepository customerRepository;
    private final MailService mailService;

    @Autowired
    public TransferServiceImpl(CustomerRepository customerRepository,MailService mailService) {
        this.customerRepository = customerRepository;
        this.mailService = mailService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transferAmount(CreateTransfersDTO transferDTO) throws Exception {
        // Fetch sender and receiver customers
        Customer sender = customerRepository.findByCustomerIdAndAccount(transferDTO.getSenderId(), transferDTO.getSenderAccount());
        Customer receiver = customerRepository.findByCustomerIdAndAccount(transferDTO.getRecipientId(), transferDTO.getReceiverAccount());

        if (sender == null || receiver == null) {
            throw new Exception("Sender or receiver account not found");
        }

        Double amount = transferDTO.getAmount();

        // Check if sender has sufficient balance
        if (sender.getBalance() < amount) {
            throw new Exception("Insufficient balance");
        }

        // Perform transfer
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        // Save updated balances
        customerRepository.save(sender);
        customerRepository.save(receiver);
        mailService.sendMail(sender, Type.TRANSFER,transferDTO.getAmount());
    }
}
