package rw.ac.rca.bankManagement.v1.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import rw.ac.rca.bankManagement.v1.enums.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "withdraws")
public class Withdraws {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID saving_id;

    @JoinColumn(name = "customer_id")
    private UUID customerId;

    @NotNull
    private String account;

    @NotNull
    private Double amount; // Change to Double

    @Column(name ="type")
    private Type type;

    private Date bankingDateTime;

//    public Savings() {
//        // Default constructor
//    }

    public Withdraws(UUID customer_id, String account, Double amount, Type type) {
        this.customerId = customer_id;
        this.account = account;
        this.amount = amount;
        this.type = type;
    }


}
