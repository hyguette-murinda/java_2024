package rw.ac.rca.bankManagement.v1.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
}

