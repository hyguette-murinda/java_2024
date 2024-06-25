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
@Table(name = "transfers")
public class Transfers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transfer_id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @NotNull
    private String account;
    @NotNull
    private String amount;
    @Column(name ="type")
    private Type type;
    private Date bankingDateTime;




}
