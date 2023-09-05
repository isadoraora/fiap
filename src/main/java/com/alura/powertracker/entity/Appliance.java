package com.alura.powertracker.entity;

import com.alura.powertracker.entity.model.ApplianceDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_appliance")
public class Appliance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String model;

  private int wattage;

  private String voltage;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;

  public Appliance(ApplianceDTO applianceDTO) {
  }

  public Appliance(Long id, String name, String model, int wattage, String voltage) {
    this.id = id;
    this.name = name;
    this.model = model;
    this.wattage = wattage;
    this.voltage = voltage;
  }

  public Appliance() {
  }
}
