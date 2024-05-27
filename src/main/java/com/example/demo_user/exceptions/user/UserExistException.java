package com.example.demo_user.exceptions.user;

import com.example.demo_user.exceptions.ExistException;

public class UserExistException extends ExistException{

  public UserExistException(String code, String message) {
    super(code, message);
  }
  
}
