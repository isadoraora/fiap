package com.alura.powertracker.domain;

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
public class ApplianceDTO {
  private String name;
  private String model;
  private String power;
  private String voltage;
  //other variables
}

