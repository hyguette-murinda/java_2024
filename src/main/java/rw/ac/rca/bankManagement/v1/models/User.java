package rw.ac.rca.bankManagement.v1.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID user_id;

    @javax.validation.constraints.NotNull
    private String email;

    @javax.validation.constraints.NotNull
    private String username;

    @javax.validation.constraints.NotNull
    private String national_id;

    @javax.validation.constraints.NotNull
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @Column
    private Date lastLogin;

    @Column
    @javax.validation.constraints.NotNull
    private String gender;

    @Column
    private String profilePicture;

    @NotNull
    private String password;

    public User(String email, String username, String national_id, String gender ,String password) {
        this.email = email;
        this.username = username;
        this.national_id = national_id;
        this.password = password;
        this.gender = gender;
    }
}