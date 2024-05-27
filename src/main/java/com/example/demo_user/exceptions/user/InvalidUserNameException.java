package com.example.demo_user.exceptions.user;

import com.example.demo_user.exceptions.InvalidInputException;

public class InvalidUserNameException extends InvalidInputException{

  public InvalidUserNameException(String code, String message) {
    super(code, message);
  }
  
}
