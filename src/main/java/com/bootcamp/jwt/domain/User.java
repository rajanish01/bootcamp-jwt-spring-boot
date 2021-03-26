package com.bootcamp.jwt.domain;

import com.bootcamp.jwt.repository.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    @NotEmpty(message = "Username Can not Be Null/Empty !")
    private String username;
    @NotEmpty(message = "Password Can not Be Null/Empty !")
    private String password;

    @NotEmpty(message = "Firstname Can not Be Null/Empty !")
    private String firstname;
    @NotEmpty(message = "Lastname Can not Be Null/Empty !")
    private String lastname;

    @Email(message = "Email Format Incorrect !")
    @NotEmpty(message = "Email Can not Be Null/Empty !")
    private String email;

    public User(UserEntity entity) {
        this.setId(entity.getId());
        this.setUsername(entity.getUsername());
        this.setPassword(entity.getPassword());
        this.setFirstname(entity.getFirstname());
        this.setLastname(entity.getLastname());
        this.setEmail(entity.getEmail());
    }

}
