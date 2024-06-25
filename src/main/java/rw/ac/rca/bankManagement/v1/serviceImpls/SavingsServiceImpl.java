package rw.ac.rca.bankManagement.v1.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateSavingsDTO;
import rw.ac.rca.bankManagement.v1.models.Customer;
import rw.ac.rca.bankManagement.v1.models.Savings;
import rw.ac.rca.bankManagement.v1.repositories.CustomerRepository;
import rw.ac.rca.bankManagement.v1.repositories.SavingsRepository;
import rw.ac.rca.bankManagement.v1.services.SavingsService;

import java.util.Optional;
import java.util.UUID;

@Service
public class SavingsServiceImpl implements SavingsService {
    private final SavingsRepository savingsRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository, CustomerRepository customerRepository) {
        this.savingsRepository = savingsRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Savings registerCustomerToSaving(CreateSavingsDTO createSavingsDTO) throws Exception {
        Savings savings = new Savings(
                createSavingsDTO.getCustomer_id(),
                createSavingsDTO.getAccount(),
                createSavingsDTO.getAmount(),
                createSavingsDTO.getType()
        );

        // Save the savings record
        try {
            savings = savingsRepository.save(savings);
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new Exception("Failed to create the savings record");
        }

        // Find the customer and update their balance
        Customer customer = customerRepository.findByCustomerId(createSavingsDTO.getCustomer_id());
        if (customer == null) {
            throw new Exception("Customer not found");
        }

        try {
            Double currentBalance = customer.getBalance();
            Double amountToAdd = Double.parseDouble(String.valueOf(createSavingsDTO.getAmount()));
            customer.setBalance(currentBalance + amountToAdd);
            customerRepository.save(customer);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid balance format");
        }

        return savings;
    }
}
