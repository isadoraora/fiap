package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Person;
import com.alura.powertracker.entity.model.PersonDTO;

public class PersonMapper {

  public static Person toEntity(PersonDTO personDTO) {
    return new Person(personDTO);
    }

  public static PersonDTO fromEntity(Person person) {
    return new PersonDTO(
        person.getId(),
        person.getName(),
        person.getCpf(),
        person.getEmail(),
        person.getBirthday(),
        person.getRelation());
  }

  public static Person mapperPersonDtoToEntity(PersonDTO personDTO, Person person) {
    person.setName(personDTO.name());
    person.setCpf(personDTO.cpf());
    person.setEmail(personDTO.email());
    person.setBirthday(personDTO.birthday());
    person.setRelation(person.getRelation());
    return person;
  }
}
