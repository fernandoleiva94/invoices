package com.sevenb.invoices.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * User entity.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1226873934060848455L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotEmpty(message = "user.password.not-empty")
    private String password;

    @Email(message = "user.username.invalid-email-format")
    @NotEmpty(message = "user.username.not-empty")
    @Column(unique = true, length = 150)
    private String username;

    @OneToOne
    private Company company;

}
