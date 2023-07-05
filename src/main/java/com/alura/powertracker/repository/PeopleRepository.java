package com.alura.powertracker.repository;

import com.alura.powertracker.domain.People;
import com.alura.powertracker.domain.model.PeopleDTO;
import com.alura.powertracker.mapper.PeopleMapper;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRepository {

  private Set<People> people = new HashSet<>();

  public void save(PeopleDTO peopleDTO) {
    People peopleEntity = PeopleMapper.toEntity(peopleDTO);
    people.add(peopleEntity);
  }
}