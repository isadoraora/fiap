package com.alura.powertracker.entity;

import com.alura.powertracker.entity.model.AddressDTO;
import com.alura.powertracker.entity.model.AddressPersonDTO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;

  private int number;

  @NotNull(message = "CEP is required.")
  @Pattern(regexp = "\\d{5}\\d{3}", message = "CEP must be on format: 00000000")
  private String cep;

  private String neighbourhood;

  private String city;

  private String state;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;

  public Address() {
  }

  public Address(
      Long id,
      String street,
      int number,
      String cep,
      String neighbourhood,
      String city,
      String state) {
    this.id = id;
    this.street = street;
    this.number = number;
    this.cep = cep;
    this.neighbourhood = neighbourhood;
    this.city = city;
    this.state = state;
  }

  public Address(AddressDTO dto) {
    this.id = dto.id();
    this.street = dto.street();
    this.number = dto.number();
    this.cep = dto.cep();
    this.neighbourhood = dto.neighbourhood();
    this.city = dto.city();
    this.state = dto.state();
  }

  public Address(AddressPersonDTO dto, Person person) {
    this.id = dto.id();
    this.street = dto.street();
    this.city = dto.city();
    this.state = dto.state();
    this.cep = dto.cep();
    this.person = person;
  }
}
