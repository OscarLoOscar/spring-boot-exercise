package com.example.demo_user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidInputException extends RuntimeException{
  private String code;
  private String message;

}
