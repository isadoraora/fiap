package com.alura.powertracker.controller;

import com.alura.powertracker.domain.ApplianceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplianceController {

  @PostMapping("/power_tracker/appliance")
  public ResponseEntity<ApplianceDTO> createApplianceRegistration(@RequestBody ApplianceDTO applianceDTO) {
    ApplianceDTO appliance = new ApplianceDTO(
        applianceDTO.getName(),
        applianceDTO.getModel(),
        applianceDTO.getPower(),
        applianceDTO.getVoltage());
    return ResponseEntity.status(HttpStatus.CREATED).body(appliance);
  }
}
