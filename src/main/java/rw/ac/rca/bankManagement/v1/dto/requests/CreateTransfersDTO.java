package rw.ac.rca.bankManagement.v1.dto.requests;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateTransfersDTO {
    @NotNull
    private UUID senderId;

    @NotNull
    private UUID recipientId;

    @NotNull
    private String account;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

