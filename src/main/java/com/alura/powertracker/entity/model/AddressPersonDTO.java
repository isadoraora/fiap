package com.alura.powertracker.entity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record AddressPersonDTO(

    Long id,

    @NotBlank(message = "Street is required and cannot be blank.")
    String street,

    @NotNull(message = "Number is required.")
    int number,

    @NotNull(message = "CEP is required.")
    @Pattern(regexp = "\\d{5}\\d{3}", message = "CEP must be on format: 00000000")
    String cep,

    @NotBlank(message = "Neighbourhood is required and cannot be blank.")
    String neighbourhood,

    @NotBlank(message = "City is required and cannot be blank.")
    String city,

    @NotBlank(message = "State is required and cannot be blank.")
    @Size(min = 2, max =2 , message = "State must be on format: XX")
    String state,

    PersonDTO personDTO
) {
}
