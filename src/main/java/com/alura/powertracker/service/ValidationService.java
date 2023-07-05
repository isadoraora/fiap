package com.alura.powertracker.service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService<T> {

  @Autowired
  private Validator validator;

  public <T> Map<Path, String> validate(T dataObj) {
    Set<ConstraintViolation<T>> validations = validator.validate(dataObj);
    Map<Path, String> validationsToMap = validations
        .stream()
        .collect(Collectors.toMap(ConstraintViolation::getPropertyPath,
            ConstraintViolation::getMessage));
    return validationsToMap;
  }
}
