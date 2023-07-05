package com.alura.powertracker.controller;

import com.alura.powertracker.domain.model.AddressDTO;
import com.alura.powertracker.repository.AddressRepository;
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
public class AddressController {

  @Autowired
  private ValidationService validationService;

  @Autowired
  private AddressRepository addressRepository;

  @PostMapping("/power_tracker/address")
  public ResponseEntity createAddressRegistration(@RequestBody AddressDTO addressDTO) {
    Map<Path, String> validationsToMap = validationService.validate(addressDTO);

    if (!validationsToMap.isEmpty()) {
      return ResponseEntity.badRequest().body(validationsToMap);
    }

    addressRepository.save(addressDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body("Address was successfully registered!");
  }
}
