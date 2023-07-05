package com.alura.powertracker.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

  @NotBlank(message = "Name is required and cannot be blank.")
  private String name;

  @NotBlank(message = "Model is required and cannot be blank.")
  private String model;

  @NotNull(message = "Wattage is required.")
  private int wattage;

  @NotBlank(message = "Voltage is required and cannot be blank.")
  private String voltage;
}

