//package rw.ac.rca.bankManagement.v1.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendSaving(String toEmail, String names) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("hyguettemurindaimfura@gmail.com");
//        message.setTo(toEmail);
//        message.setText("Dear " + names + "!\n" +
//                "\n" +
//                "You've saved money, " );
//        message.setSubject("SPRING-STARTER VERIFICATION CODE");
//        mailSender.send(message);
//    }
//}
