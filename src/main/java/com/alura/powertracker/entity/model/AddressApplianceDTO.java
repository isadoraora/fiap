package com.alura.powertracker.entity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AddressApplianceDTO(

    Long id,
    @NotBlank(message = "Name is required and cannot be blank.")
    String name,

    @NotBlank(message = "Model is required and cannot be blank.")
    String model,

    @NotNull(message = "Wattage is required.")
    int wattage,

    @NotBlank(message = "Voltage is required and cannot be blank.")
    String voltage
) {
}

