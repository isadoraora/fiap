package com.alura.powertracker.entity.model;

import com.alura.powertracker.entity.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record UserDTO(
    Long id,
    @NotBlank(message = "Username is required and cannot be blank.")
    String username,
    @NotBlank(message = "Password is required and cannot be blank.")
    @Size(min = 6, message = "Password must have at list 6 characters.")
    String password
) {

    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword());
    }

}
