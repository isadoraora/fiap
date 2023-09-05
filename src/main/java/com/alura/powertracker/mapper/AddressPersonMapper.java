package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Address;
import com.alura.powertracker.entity.Person;
import com.alura.powertracker.entity.model.AddressPersonDTO;

public class AddressPersonMapper {

  public static Address toEntity(AddressPersonDTO addressPersonDTO, Person person) {
    return new Address(addressPersonDTO, person);
  }

  public static AddressPersonDTO fromEntity(Address address) {
    return new AddressPersonDTO(
        address.getId(),
        address.getStreet(),
        address.getNumber(),
        address.getCep(),
        address.getNeighbourhood(),
        address.getCity(),
        address.getState(),
        address.getPerson() != null ? PersonMapper.fromEntity(address.getPerson()) : null
    );
  }

  public static Address mapperDtoToEntity(AddressPersonDTO addressPersonDTO, Address address, Person person) {
    address.setStreet(addressPersonDTO.street());
    address.setNumber(addressPersonDTO.number());
    address.setCep(addressPersonDTO.cep());
    address.setNeighbourhood(addressPersonDTO.neighbourhood());
    address.setCity(addressPersonDTO.city());
    address.setState(addressPersonDTO.state());
    address.setPerson(person);
    return address;
  }
}
