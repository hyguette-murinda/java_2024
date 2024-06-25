package rw.ac.rca.bankManagement.v1.services;

import rw.ac.rca.bankManagement.v1.dto.requests.CreateCustomerDTO;
import rw.ac.rca.bankManagement.v1.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(CreateCustomerDTO createCustomerDTO) throws Exception;
//    Customer getCustomerById(UUID student_id) throws Exception;
    List<Customer> getAllCustomers() throws Exception;
//    Page<Student> getAllStudentsPaginated(Pageable pageable) throws Exception;
//    String deleteStudent(UUID student_id) throws Exception;
//    Student updateStudent(UUID student_id, CreateStudentDTO createStudentDTO) throws Exception;
}
