package com.alura.powertracker.entity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record UserPersonDTO(
    Long id,
    @NotBlank(message = "Name is required and cannot be blank.")
    String username,
    @NotBlank(message = "Password is required and cannot be blank.")
    @Size(min = 6, message = "Password must have at list 6 characters.")
    String password,
    PersonDTO personDTO
) {
}
