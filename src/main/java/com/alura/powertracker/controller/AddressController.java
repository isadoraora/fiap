package com.alura.powertracker.controller;

import com.alura.powertracker.domain.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

  @PostMapping("/power_tracker/address")
  public ResponseEntity<AddressDTO> createAddressRegistration(@RequestBody AddressDTO address) {
    AddressDTO addressDTO = new AddressDTO(
        address.getStreet(),
        address.getNumber(),
        address.getNeighbourhood(),
        address.getCity(),
        address.getState());
    return ResponseEntity.status(HttpStatus.CREATED).body(addressDTO);
  }
}
