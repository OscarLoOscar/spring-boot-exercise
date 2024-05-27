package com.example.demo_user.exceptions.user;

import com.example.demo_user.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException{

  public UserNotFoundException(String code, String message) {
    super(code, message);
  }
}
