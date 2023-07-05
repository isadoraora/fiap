package com.alura.powertracker.mapper;

import com.alura.powertracker.domain.Address;
import com.alura.powertracker.domain.model.AddressDTO;

public class AddressMapper {

  public static Address toEntity(AddressDTO addressDTO) {
    if (addressDTO == null) {
      return null;
    }

    Address address = new Address();
    address.setStreet(addressDTO.getStreet());
    address.setNumber(addressDTO.getNumber());
    address.setNeighbourhood(addressDTO.getNeighbourhood());
    address.setCity(addressDTO.getCity());
    address.setState(addressDTO.getState());
    return address;
  }
}
