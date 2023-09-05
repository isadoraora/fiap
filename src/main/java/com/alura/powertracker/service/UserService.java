package com.alura.powertracker.service;

import com.alura.powertracker.entity.User;
import com.alura.powertracker.entity.model.UserDTO;
import com.alura.powertracker.entity.model.UserPersonDTO;
import com.alura.powertracker.exception.GatewayException;
import com.alura.powertracker.exception.NotFoundException;
import com.alura.powertracker.mapper.UserMapper;
import com.alura.powertracker.mapper.UserPersonMapper;
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
public class UserService {

  private final IUserRepository iUserRepository;

  @Transactional(readOnly = true)
  public Page<UserPersonDTO> findAll(PageRequest pageRequest) {
    var address = iUserRepository.findAll(pageRequest);
    return address.map(UserPersonMapper::fromEntity);
  }

  @Transactional(readOnly = true)
  public UserPersonDTO findById(Long id) {
    var address = iUserRepository.findById(id).orElseThrow(
        () -> new NotFoundException("User not found.")
    );

    return UserPersonMapper.fromEntity(address);
  }

  @Transactional
  public UserDTO save(UserDTO userDTO) {
    var entity = UserMapper.toEntity(userDTO);
    var savedAddress = iUserRepository.save(entity);
    return UserMapper.fromEntity(savedAddress);
  }

  @Transactional
  public UserDTO update(Long id, UserDTO userDTO) {
    try {
      User user = iUserRepository.getReferenceById(id);
      UserMapper.mapperDtoToEntity(userDTO, user);
      user = iUserRepository.save(user);
      return UserMapper.fromEntity(user);

    } catch (EntityNotFoundException enf) {
      throw new NotFoundException("User not found, id: " + id);
    }
  }

  @Transactional
  public void delete(Long id) {
    try {
      iUserRepository.deleteById(id);
    } catch (DataIntegrityViolationException die) {
      throw new GatewayException("Data integrity violation");
    }
  }
}
