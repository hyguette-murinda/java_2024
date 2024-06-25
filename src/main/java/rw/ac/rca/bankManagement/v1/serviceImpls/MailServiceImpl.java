package rw.ac.rca.bankManagement.v1.serviceImpls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rw.ac.rca.bankManagement.v1.enums.Type;
import rw.ac.rca.bankManagement.v1.models.Customer;
import rw.ac.rca.bankManagement.v1.services.MailService;

@Service

public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    SimpleMailMessage mail = new SimpleMailMessage();

    @Override
    public void sendMail(Customer customer, Type transactionType, Double amount) {
        mail.setTo(customer.getEmail());
        mail.setSubject("Transaction Notification");
        mail.setText("Dear " + customer.getFirstName() +" "+ customer.getLastName() + ", your " + transactionType + " of " + amount + " frw on your account " + customer.getAccount() + " has been completed successfully.");
        javaMailSender.send(mail);
    }
}