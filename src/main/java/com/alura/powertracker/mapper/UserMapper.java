package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.User;
import com.alura.powertracker.entity.model.UserDTO;

public class UserMapper {

  public static User toEntity(UserDTO userDTO) {
    return new User(
        userDTO.username(),
        userDTO.password());
  }

  public static UserDTO fromEntity(User user) {
    return new UserDTO(
        user.getId(),
        user.getUsername(),
        user.getPassword()
    );
  }

  public static User mapperDtoToEntity(UserDTO userDTO, User user) {
    user.setUsername(userDTO.username());
    user.setPassword(userDTO.password());
    return user;
  }

}
