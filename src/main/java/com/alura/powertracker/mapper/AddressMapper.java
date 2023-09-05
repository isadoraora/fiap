package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Address;
import com.alura.powertracker.entity.model.AddressDTO;

public class AddressMapper {

  public static Address toEntity(AddressDTO addressDTO) {
    return new Address(addressDTO);
  }

  public static AddressDTO fromEntity(Address address) {
    return new AddressDTO(
        address.getId(),
        address.getStreet(),
        address.getNumber(),
        address.getCep(),
        address.getNeighbourhood(),
        address.getCity(),
        address.getState());
  }

  public static Address mapperDtoToEntity(AddressDTO addressDTO, Address address) {
    address.setStreet(addressDTO.street());
    address.setNumber(addressDTO.number());
    address.setCep(addressDTO.cep());
    address.setNeighbourhood(addressDTO.neighbourhood());
    address.setCity(addressDTO.city());
    address.setState(addressDTO.state());
    return address;
  }
}
