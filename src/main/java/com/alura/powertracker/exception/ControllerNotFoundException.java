package com.alura.powertracker.exception;

public class ControllerNotFoundException extends RuntimeException{

  public ControllerNotFoundException(String message){
    super(message);
  }
}
