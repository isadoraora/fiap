package com.alura.powertracker.mapper;

import com.alura.powertracker.domain.Appliance;
import com.alura.powertracker.domain.model.ApplianceDTO;

public class ApplianceMapper {

  public static Appliance toEntity(ApplianceDTO applianceDTO) {
    if (applianceDTO == null) {
      return null;
    }

    Appliance appliance = new Appliance();
    appliance.setName(applianceDTO.getName());
    appliance.setModel(applianceDTO.getModel());
    appliance.setWattage(applianceDTO.getWattage());
    appliance.setVoltage(applianceDTO.getVoltage());
    return appliance;
  }
}
