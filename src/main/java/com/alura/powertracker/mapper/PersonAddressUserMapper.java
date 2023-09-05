package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.Person;
import com.alura.powertracker.entity.model.AddressDTO;
import com.alura.powertracker.entity.model.PersonAddressUserDTO;
import com.alura.powertracker.entity.model.UserDTO;
import java.util.HashSet;
import java.util.Set;

public class PersonAddressUserMapper {

  public static PersonAddressUserDTO fromEntity(Person person) {
    Set<AddressDTO> addressDTOSet = new HashSet<>();

    if (!person.getAddresses().isEmpty()) {
      person.getAddresses().forEach( address -> {
        addressDTOSet.add(AddressMapper.fromEntity(address));
      });
    }

    return new PersonAddressUserDTO(
        person.getId(),
        person.getName(),
        person.getCpf(),
        person.getEmail(),
        person.getBirthday(),
        person.getRelation(),
        addressDTOSet,
        person.getUser() != null ? new UserDTO(person.getUser()) : null
    );
  }

}
