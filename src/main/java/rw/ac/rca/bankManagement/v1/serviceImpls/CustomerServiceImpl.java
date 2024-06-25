package rw.ac.rca.bankManagement.v1.serviceImpls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import rw.ac.rca.bankManagement.v1.dto.requests.CreateCustomerDTO;
import rw.ac.rca.bankManagement.v1.models.Customer;
import rw.ac.rca.bankManagement.v1.repositories.CustomerRepository;
import rw.ac.rca.bankManagement.v1.services.CustomerService;

import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  final CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(CreateCustomerDTO createCustomerDTO) throws Exception {
        Customer customer = new Customer (
                createCustomerDTO.getFirstName(),
                createCustomerDTO.getLastName(),
                createCustomerDTO.getEmail(),
                createCustomerDTO.getMobile(),
                createCustomerDTO.getDob(),
                createCustomerDTO.getAccount(),
                createCustomerDTO.getBalance()
        );
        try {
            return customerRepository.save(customer);
        } catch (HttpServerErrorException.InternalServerError e){
            throw new Exception("Failed to create the student");
        }

    }


    @Override
    public List<Customer> getAllCustomers() throws Exception {
        try {
            return  customerRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Failed to get students");
        }
    }


}
