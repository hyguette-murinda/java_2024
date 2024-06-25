package rw.ac.rca.bankManagement.v1.services;

import rw.ac.rca.bankManagement.v1.enums.Type;
import rw.ac.rca.bankManagement.v1.models.Customer;

public interface MailService {
    void sendMail(Customer client, Type type, Double amount);


}