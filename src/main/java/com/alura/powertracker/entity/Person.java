package com.alura.powertracker.entity;

import com.alura.powertracker.entity.model.PersonDTO;
import com.alura.powertracker.entity.model.PersonUserDTO;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_person")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String cpf;

  private String email;

  private LocalDate birthday;

  private String gender;

  private String relation;

  @OneToMany(mappedBy = "person")
  private Set<Address> addresses = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Person(Long id, String name, LocalDate birthday, String cpf, String email) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.cpf = cpf;
    this.email = email;
  }

  public Person(PersonDTO dto) {
    this.id = dto.id();
    this.name = dto.name();
    this.birthday = dto.birthday();
    this.cpf = dto.cpf();
    this.email = dto.email();
  }

  public Person(PersonUserDTO dto, User user) {
    this.id = dto.id();
    this.name = dto.name();
    this.birthday = dto.birthday();
    this.cpf = dto.cpf();
    this.email = dto.email();
    this.user = user;
  }
  public Person() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person person)) return false;

    return getId().equals(person.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthday=" + birthday +
        '}';
  }
}
