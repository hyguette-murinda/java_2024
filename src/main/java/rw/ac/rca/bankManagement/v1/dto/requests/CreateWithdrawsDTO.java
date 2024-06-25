package rw.ac.rca.bankManagement.v1.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import rw.ac.rca.bankManagement.v1.enums.Type;
import rw.ac.rca.bankManagement.v1.models.Customer;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateWithdrawsDTO {
    @NotNull
    private UUID customer_id;

    @NotNull
    private Double amount; // Change to Double

    @NotNull
    @Size(min = 3)
    private Type type;

    @NotNull
    @Size(min = 16)
    private String account;

}
