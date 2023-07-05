package com.alura.powertracker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private String street;

  private int number;

  private String neighbourhood;

  private String city;

  private String state;
}
