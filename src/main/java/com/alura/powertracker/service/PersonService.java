package com.alura.powertracker.service;

import com.alura.powertracker.entity.Person;
import com.alura.powertracker.entity.model.PersonAddressUserDTO;
import com.alura.powertracker.entity.model.PersonUserDTO;
import com.alura.powertracker.exception.GatewayException;
import com.alura.powertracker.exception.NotFoundException;
import com.alura.powertracker.mapper.PersonAddressUserMapper;
import com.alura.powertracker.mapper.PersonUserMapper;
import com.alura.powertracker.repository.IPersonRepository;
import com.alura.powertracker.repository.IUserRepository;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final IPersonRepository iPersonRepository;
  private final IUserRepository iUserRepository;

  @Transactional(readOnly = true)
  public Page<PersonAddressUserDTO> findAll(PageRequest pageRequest) {
    var addresses = iPersonRepository.findAll(pageRequest);
    return addresses.map(PersonAddressUserMapper::fromEntity);
  }

  @Transactional(readOnly = true)
  public PersonAddressUserDTO findById(Long id) {
    var address = iPersonRepository.findById(id).orElseThrow(
        () -> new NotFoundException("Person not found.")
    );

    return PersonAddressUserMapper.fromEntity(address);
  }

  @Transactional
  public PersonUserDTO save(PersonUserDTO personUserDTO) {
    try {
      var user = iUserRepository.getReferenceById(personUserDTO.id());
      var entity = PersonUserMapper.toEntity(personUserDTO, user);
      var savedAddress = iPersonRepository.save(entity);
      return PersonUserMapper.fromEntity(savedAddress);

    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }

  }

  @Transactional
  public PersonUserDTO update(Long id, PersonUserDTO personUserDTO) {
    try {
      var user = iUserRepository.getReferenceById(personUserDTO.id());
      Person entity = iPersonRepository.getReferenceById(id);
      PersonUserMapper.mapperDtoToEntity(personUserDTO, entity, user);
      entity = iPersonRepository.save(entity);
      return PersonUserMapper.fromEntity(entity);

    } catch (EntityNotFoundException enf) {
      throw new NotFoundException("Appliance not found.");
    }
  }

  @Transactional
  public void delete(Long id)  {
    try {
      iPersonRepository.deleteById(id);
    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }

}
