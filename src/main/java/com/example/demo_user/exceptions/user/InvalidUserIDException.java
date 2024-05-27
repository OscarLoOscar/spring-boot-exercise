package com.example.demo_user.exceptions.user;

import com.example.demo_user.exceptions.InvalidInputException;

public class InvalidUserIDException extends InvalidInputException{

  public InvalidUserIDException(String code, String message) {
    super(code, message);
  }
  
}
