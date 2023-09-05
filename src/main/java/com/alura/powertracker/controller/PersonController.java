package com.alura.powertracker.controller;

import com.alura.powertracker.entity.model.PersonAddressUserDTO;
import com.alura.powertracker.entity.model.PersonUserDTO;
import com.alura.powertracker.service.PersonService;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/power_tracker/person")
public class PersonController {

  private final PersonService personService;

  @GetMapping
  public ResponseEntity<Page<PersonAddressUserDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage
  ) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage);
    var people = personService.findAll(pageRequest);
    return ResponseEntity.ok(people);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonAddressUserDTO> findById(@PathVariable Long id) {
    var person = personService.findById(id);
    return ResponseEntity.ok(person);
  }

  @PostMapping
  public ResponseEntity<PersonUserDTO> save(@Valid @RequestBody PersonUserDTO personUserDTO) {
    var person = personService.save(personUserDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((person.id())).toUri();
    return ResponseEntity.created(uri).body(person);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PersonUserDTO> update(@Valid @RequestBody PersonUserDTO personUserDTO,
      @PathVariable Long id) {
    var person = personService.update(id, personUserDTO);
    return ResponseEntity.ok(person);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    personService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
