package rw.ac.rca.bankManagement.v1.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateCustomerDTO {
    @Size(min=3)
    @NotNull
    private String firstName;
    @Size(min=3)
    @NotNull
    private String lastName;

    @Email
    private String email;
    @NotNull
    @Size(min = 3)
    private String mobile;
    @Past(message = "Date of birth should be in the past")
    @NotNull
    @Size(min = 2)
    private LocalDate dob;
    @NotNull
    @Size(min = 3)
    private String account;
    @NotNull
    @Size(min = 1)
    private Double balance;
}
