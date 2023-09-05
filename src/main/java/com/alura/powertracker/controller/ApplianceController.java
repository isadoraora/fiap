package com.alura.powertracker.controller;

import com.alura.powertracker.entity.model.ApplianceDTO;
import com.alura.powertracker.service.ApplianceService;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/power_tracker/appliance")
public class ApplianceController {

  @Autowired
  private ApplianceService applianceService;

  @GetMapping
  public ResponseEntity<Page<ApplianceDTO>> findAll(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "size", defaultValue = "10") Integer size
  ) {
    PageRequest pageRequest = PageRequest.of(page, size);
    var appliances = applianceService.findAll(pageRequest);
    return ResponseEntity.ok(appliances);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApplianceDTO> findById(@PathVariable Long id) {
    var appliance = applianceService.findById(id);
    return ResponseEntity.ok(appliance);
  }

  @PostMapping
  public ResponseEntity<ApplianceDTO> save(@Valid @RequestBody ApplianceDTO applianceDTO) {
    var savedAppliance = applianceService.save(applianceDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((savedAppliance.id())).toUri();
    return ResponseEntity.created(uri).body(savedAppliance);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApplianceDTO> update(@RequestBody ApplianceDTO applianceDTO, @PathVariable Long id) {
    var updatedAppliance = applianceService.update(id, applianceDTO);
    return  ResponseEntity.ok(updatedAppliance);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    applianceService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
