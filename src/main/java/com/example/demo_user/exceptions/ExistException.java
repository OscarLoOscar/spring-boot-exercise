package com.example.demo_user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExistException extends RuntimeException {
  private String code;
  private String message;

}
