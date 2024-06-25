package rw.ac.rca.bankManagement.v1.dto.requests;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateTransfersDTO {
    @NotNull
    private UUID senderId;

    @NotNull
    private UUID recipientId;

    @NotNull
    private String senderAccount;

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    @NotNull
    private String receiverAccount;

    @NotNull
    private Double amount;

    // Getters and setters
    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UUID recipientId) {
        this.recipientId = recipientId;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}

