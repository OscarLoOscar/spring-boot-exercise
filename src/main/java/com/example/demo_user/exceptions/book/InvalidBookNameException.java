package com.example.demo_user.exceptions.book;

import com.example.demo_user.exceptions.InvalidInputException;

public class InvalidBookNameException extends InvalidInputException{

  public InvalidBookNameException(String code, String message) {
    super(code, message);
  }
  
}
