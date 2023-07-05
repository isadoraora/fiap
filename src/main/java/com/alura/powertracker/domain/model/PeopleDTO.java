package com.alura.powertracker.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PeopleDTO {

  @NotBlank(message = "Name is required and cannot be blank.")
  private String name;

  @CPF
  @NotNull(message = "CPF is required.")
  private String cpf;

  @Past(message = "Must be a past date.")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate birthday;

  private String gender;

  @NotBlank(message = "Relationship is required and cannot be blank.")
  private String relation;

  private boolean liveTogether;
}
