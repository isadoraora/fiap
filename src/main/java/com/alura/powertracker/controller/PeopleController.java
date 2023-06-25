package com.alura.powertracker.controller;

import com.alura.powertracker.domain.PeopleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
  @PostMapping("/power_tracker/people")
  public ResponseEntity<PeopleDTO> createPersonRegistration(@RequestBody PeopleDTO people) {
    PeopleDTO person = new PeopleDTO(
        people.getName(),
        people.getCpf(),
        people.getBirthday(),
        people.getGender(),
        people.getRelation(),
        people.isLiveTogether());
    return ResponseEntity.status(HttpStatus.CREATED).body(person);
  }
}
