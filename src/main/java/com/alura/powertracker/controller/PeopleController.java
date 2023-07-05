package com.alura.powertracker.controller;

import com.alura.powertracker.domain.model.PeopleDTO;
import com.alura.powertracker.repository.PeopleRepository;
import com.alura.powertracker.service.ValidationService;
import java.util.Map;
import javax.validation.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

  @Autowired
  private ValidationService<PeopleDTO> validationService;

  @Autowired
  private PeopleRepository peopleRepository;

  @PostMapping("/power_tracker/people")
  public ResponseEntity createPersonRegistration(@RequestBody PeopleDTO peopleDTO) {
    Map<Path, String> validationsToMap = validationService.validate(peopleDTO);

    if (!validationsToMap.isEmpty()) {
      return ResponseEntity.badRequest().body(validationsToMap);
    }

    peopleRepository.save(peopleDTO);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(String.format(" %s, your account was successfully created!", peopleDTO.getName()));
  }
}
