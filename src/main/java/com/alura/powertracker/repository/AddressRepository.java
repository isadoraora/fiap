package com.alura.powertracker.repository;

import com.alura.powertracker.domain.model.AddressDTO;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {

  private Set<AddressDTO> addresses;

  public AddressRepository(){
    addresses = new HashSet<>();
  }

  public void save(AddressDTO addressDTO) {
    addresses.add(addressDTO);
  }

}
