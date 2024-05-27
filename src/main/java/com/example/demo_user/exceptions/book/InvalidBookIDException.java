package com.example.demo_user.exceptions.book;

import com.example.demo_user.exceptions.InvalidInputException;

public class InvalidBookIDException extends InvalidInputException{

  public InvalidBookIDException(String code, String message) {
    super(code, message);
  }
  
}
