package rw.ac.rca.bankManagement.v1.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateUserDTO {

    @Email
    private String email;
    @NotNull
    @Size(min = 3)
    private String username;
    @NotNull
    @Size(min = 1)
    private String gender;
    @NotNull
    @Size(min = 16)
    private String national_id;
    @NotNull
    @Size(min = 3)
    private String password;
}
