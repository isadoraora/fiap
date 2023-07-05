package com.alura.powertracker.mapper;

import com.alura.powertracker.domain.People;
import com.alura.powertracker.domain.model.PeopleDTO;

public class PeopleMapper {

  public static People toEntity(PeopleDTO peopleDTO) {
    if (peopleDTO == null) {
      return null;
    }

    People people = new People();
    people.setName(peopleDTO.getName());
    people.setCpf(peopleDTO.getCpf());
    people.setBirthday(peopleDTO.getBirthday());
    people.setGender(peopleDTO.getGender());
    people.setRelation(peopleDTO.getRelation());
    people.setLiveTogether(peopleDTO.isLiveTogether());

    return people;
  }
}
