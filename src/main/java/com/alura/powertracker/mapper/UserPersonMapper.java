package com.alura.powertracker.mapper;

import com.alura.powertracker.entity.User;
import com.alura.powertracker.entity.model.PersonDTO;
import com.alura.powertracker.entity.model.UserPersonDTO;

public class UserPersonMapper {

  public static UserPersonDTO fromEntity(User user) {
    return new UserPersonDTO(
        user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getPeople() != null && user.getPeople().isEmpty() ? new PersonDTO(user.getPeople().iterator().next()) : null
    );
  }
}
