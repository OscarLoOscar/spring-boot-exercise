package com.example.demo_user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse extends RuntimeException {
  private String code;
  private String message;

}
