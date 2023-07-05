package com.alura.powertracker.controller;

import com.alura.powertracker.domain.model.ApplianceDTO;
import com.alura.powertracker.repository.ApplianceRepository;
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
public class ApplianceController {

  @Autowired
  private ValidationService validationService;

  @Autowired
  private ApplianceRepository applianceRepository;

  @PostMapping("/power_tracker/appliance")
  public ResponseEntity createApplianceRegistration(@RequestBody ApplianceDTO applianceDTO) {
    Map<Path, String> validationsToMap = validationService.validate(applianceDTO);

    if (!validationsToMap.isEmpty()) {
      return ResponseEntity.badRequest().body(validationsToMap);
    }

    applianceRepository.save(applianceDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body("Appliance was successfully registered!");
  }
}
