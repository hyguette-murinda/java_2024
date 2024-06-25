package rw.ac.rca.bankManagement.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import rw.ac.rca.bankManagement.v1.enums.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @javax.validation.constraints.NotNull
    private UUID senderId;

    @javax.validation.constraints.NotNull
    private UUID recipientId;

    @javax.validation.constraints.NotNull
    private String senderAccount;
    @NotNull
    private String receiverAccount;


    public Transfers(UUID recipientId, UUID senderId, String senderAccount, String receiverAccount) {
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;

    }
}
