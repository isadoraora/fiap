package com.alura.powertracker.controller;

import com.alura.powertracker.entity.model.AddressPersonDTO;
import com.alura.powertracker.service.AddressService;
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
@RequestMapping("/power_tracker/address")
public class AddressController {

  private final AddressService addressService;

  @PostMapping
  public ResponseEntity<AddressPersonDTO> save(@Valid @RequestBody AddressPersonDTO addressPersonDTO) {
    var address = addressService.save(addressPersonDTO);
    var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((address.id())).toUri();
    return ResponseEntity.created(uri).body(address);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AddressPersonDTO> update(@Valid @RequestBody AddressPersonDTO addressPersonDTO,
                                                 @PathVariable Long id) {
    var address = addressService.update(id, addressPersonDTO);
    return ResponseEntity.ok(address);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    addressService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<Page<AddressPersonDTO>> findAll(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage
  ) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage);
    var addresses = addressService.findAll(pageRequest);
    return ResponseEntity.of(java.util.Optional.ofNullable(addresses));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AddressPersonDTO> findById(@PathVariable Long id) {
    var address = addressService.findById(id);
    return ResponseEntity.of(java.util.Optional.ofNullable(address));
  }
}
