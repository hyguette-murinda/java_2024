//package rw.ac.rca.bankManagement.v1.models;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.UUID;
//
//@Entity
//@Table(name = "messages")
//public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//    private Customer customer;
//
//    private String message;
//
//    private Date dateTime;
//
//    // Getters and setters
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Date getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(Date dateTime) {
//        this.dateTime = dateTime;
//    }
//}
