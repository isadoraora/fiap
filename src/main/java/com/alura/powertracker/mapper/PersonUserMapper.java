package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Person;
import com.alura.powertracker.entity.User;
import com.alura.powertracker.entity.model.PersonUserDTO;

public class PersonUserMapper {

  public static Person toEntity(PersonUserDTO personUserDTO, User user) {
    return new Person(personUserDTO, user);
  }

  public static PersonUserDTO fromEntity(Person person) {
    return new PersonUserDTO(
        person.getId(),
        person.getName(),
        person.getCpf(),
        person.getEmail(),
        person.getBirthday(),
        person.getRelation());
  }

  public static Person mapperDtoToEntity(PersonUserDTO personUserDTO, Person person, User user) {
    person.setName(personUserDTO.name());
    person.setCpf(personUserDTO.cpf());
    person.setEmail(personUserDTO.email());
    person.setBirthday(personUserDTO.birthday());
    person.setRelation(personUserDTO.relation());
    person.setUser(user);
    return person;
  }
}
