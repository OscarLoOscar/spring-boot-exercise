package com.example.demo_user.exceptions.book;

import com.example.demo_user.exceptions.ExistException;

public class BookExistException extends ExistException{

  public BookExistException(String code, String message) {
    super(code, message);
  }
  
}