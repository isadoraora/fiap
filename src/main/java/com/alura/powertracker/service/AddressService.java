package com.alura.powertracker.service;

import com.alura.powertracker.entity.model.AddressPersonDTO;
import com.alura.powertracker.exception.GatewayException;
import com.alura.powertracker.exception.NotFoundException;
import com.alura.powertracker.mapper.AddressPersonMapper;
import com.alura.powertracker.repository.IAddressRepository;
import com.alura.powertracker.repository.IPersonRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
  private final IAddressRepository iAddressRepository;
  private final IPersonRepository iPersonRepository;

  @Autowired
  public AddressService(IAddressRepository iAddressRepository, IPersonRepository iPersonRepository) {
    this.iAddressRepository = iAddressRepository;
    this.iPersonRepository = iPersonRepository;
  }

  @Transactional(readOnly = true)
  public Page<AddressPersonDTO> findAll(PageRequest pageRequest) {
    var addresses = iAddressRepository.findAll(pageRequest);
    return addresses.map(AddressPersonMapper::fromEntity);
  }

  @Transactional(readOnly = true)
  public AddressPersonDTO findById(Long id) {
    var address = iAddressRepository.findById(id).orElseThrow(
        () -> new NotFoundException("Address not found.")
    );
    return AddressPersonMapper.fromEntity(address);
  }

  @Transactional
  public AddressPersonDTO save(AddressPersonDTO addressPersonDTO) {
    try {
      var person = iPersonRepository.getReferenceById(addressPersonDTO.id());
      var entity = AddressPersonMapper.toEntity(addressPersonDTO, person);
      var savedAddress = iAddressRepository.save(entity);
      return AddressPersonMapper.fromEntity(savedAddress);

    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }

  @Transactional
  public AddressPersonDTO update(Long id, AddressPersonDTO addressPersonDTO) {
    try {
      var address = iAddressRepository.getReferenceById(id);
      var person = iPersonRepository.getReferenceById(addressPersonDTO.personDTO().id());
      AddressPersonMapper.mapperDtoToEntity(addressPersonDTO, address, person);
      address = iAddressRepository.save(address);
      return AddressPersonMapper.fromEntity(address);

    } catch (EntityNotFoundException enf) {
      throw new NotFoundException("Person/Address not found.");
    }
  }

  @Transactional
  public void delete(Long id) {
    try {
      iAddressRepository.deleteById(id);
    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }

}
