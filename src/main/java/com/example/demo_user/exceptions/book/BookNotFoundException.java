package com.example.demo_user.exceptions.book;

import com.example.demo_user.exceptions.NotFoundException;

public class BookNotFoundException extends NotFoundException{

  public BookNotFoundException(String code, String message) {
    super(code, message);
  }
}