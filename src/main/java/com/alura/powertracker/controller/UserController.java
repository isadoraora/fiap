package com.alura.powertracker.controller;

import com.alura.powertracker.entity.model.UserDTO;
import com.alura.powertracker.entity.model.UserPersonDTO;
import com.alura.powertracker.service.UserService;
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
@RequestMapping("/power_tracker/user")
public class UserController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<Page<UserPersonDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "20") Integer linesPerPage
  ) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage);
    var users = userService.findAll(pageRequest);
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserPersonDTO> findById(@PathVariable Long id) {
    var user = userService.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO) {
    var user = userService.save(userDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((user.id())).toUri();
    return ResponseEntity.created(uri).body(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
    var user = userService.update(id, userDTO);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
