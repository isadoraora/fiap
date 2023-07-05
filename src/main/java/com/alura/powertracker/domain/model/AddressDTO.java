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
public class AddressDTO {

  @NotBlank(message = "Street is required and cannot be blank.")
  private String street;

  @NotNull(message = "Number is required.")
  private int number;

  @NotBlank(message = "Neighbourhood is required and cannot be blank.")
  private String neighbourhood;

  @NotBlank(message = "City is required and cannot be blank.")
  private String city;

  @NotBlank(message = "State is required and cannot be blank.")
  private String state;
}
