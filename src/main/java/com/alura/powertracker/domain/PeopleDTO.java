package com.alura.powertracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PeopleDTO {
  private String name;
  private String cpf;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate birthday;
  private String gender;
  private String relation;
  private boolean liveTogether;
  ///other variables
}
