package com.alura.powertracker.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
  private String name;

  private String cpf;

  private LocalDate birthday;

  private String gender;

  private String relation;

  private boolean liveTogether;
}
