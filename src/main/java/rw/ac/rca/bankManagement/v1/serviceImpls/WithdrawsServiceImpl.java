package rw.ac.rca.bankManagement.v1.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateWithdrawsDTO;
import rw.ac.rca.bankManagement.v1.enums.Type;
import rw.ac.rca.bankManagement.v1.models.Customer;
import rw.ac.rca.bankManagement.v1.models.Withdraws;
import rw.ac.rca.bankManagement.v1.repositories.CustomerRepository;
import rw.ac.rca.bankManagement.v1.repositories.WithDrawsRepository;
import rw.ac.rca.bankManagement.v1.services.MailService;
import rw.ac.rca.bankManagement.v1.services.WithdrawsService;

@Service
public class WithdrawsServiceImpl implements WithdrawsService {
    private final WithDrawsRepository withDrawsRepository;
    private final CustomerRepository customerRepository;
    private final MailService mailService;

    @Autowired
    public WithdrawsServiceImpl(WithDrawsRepository savingsRepository, CustomerRepository customerRepository,MailService mailService) {
        this.withDrawsRepository = savingsRepository;
        this.customerRepository = customerRepository;
        this.mailService = mailService;
    }

    @Override
    public Withdraws registerCustomerToWithdraw(CreateWithdrawsDTO createWithdrawsDTO) throws Exception {
        Withdraws withdraws = new Withdraws(
                createWithdrawsDTO.getCustomer_id(),
                createWithdrawsDTO.getAccount(),
                createWithdrawsDTO.getAmount(),
                createWithdrawsDTO.getType()
        );

        // Save the savings record
        try {
            withdraws = withDrawsRepository.save(withdraws);
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new Exception("Failed to create the savings record");
        }

        // Find the customer and update their balance
        Customer customer = customerRepository.findByCustomerId(createWithdrawsDTO.getCustomer_id());
        if (customer == null) {
            throw new Exception("Customer not found");
        }

        try {
            Double currentBalance = customer.getBalance();
            if (currentBalance < createWithdrawsDTO.getAmount()) {
                throw new Exception("Insufficient balance");
            }
            Double amountToAdd = Double.parseDouble(String.valueOf(createWithdrawsDTO.getAmount()));
            customer.setBalance(currentBalance - amountToAdd);
            customerRepository.save(customer);
            mailService.sendMail(customer, Type.WITHDRAW,createWithdrawsDTO.getAmount());
        } catch (NumberFormatException e) {
            throw new Exception("Invalid balance format");
        }

        return withdraws;
    }
}
