package com.alura.powertracker.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

public record PersonAddressUserDTO(
    Long id,

    @NotBlank(message = "Name is required and cannot be blank.")
    String name,

    @CPF
    @NotNull(message = "CPF is required.")
    String cpf,

    String email,

    @Past(message = "Must be a past date.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthday,

    @NotBlank(message = "Relationship is required and cannot be blank.")
    String relation,

    Set<AddressDTO> addressesDto,

    UserDTO userDTO

    ) {

}
