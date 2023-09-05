package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Appliance;
import com.alura.powertracker.entity.model.ApplianceDTO;

public class ApplianceMapper {

  public static Appliance toEntity(ApplianceDTO applianceDTO) {
    return new Appliance(applianceDTO);
  }

  public static ApplianceDTO fromEntity(Appliance appliance) {

    return new ApplianceDTO(
        appliance.getId(),
        appliance.getName(),
        appliance.getModel(),
        appliance.getWattage(),
        appliance.getVoltage()
    );
  }

  public static Appliance mapperDtoToEntity(ApplianceDTO applianceDTO, Appliance appliance) {
    appliance.setName(applianceDTO.name());
    appliance.setModel(applianceDTO.model());
    appliance.setWattage(applianceDTO.wattage());
    appliance.setVoltage(applianceDTO.voltage());
    return appliance;
  }
}
