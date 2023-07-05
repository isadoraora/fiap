package com.alura.powertracker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {

  private String name;

  private String model;

  private int wattage;

  private String voltage;
}
