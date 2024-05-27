package com.example.demo_user.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo_user.exceptions.book.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ErrorResponse notFoundException(NotFoundException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(InvalidInputException.class)
  public ErrorResponse invalidInputException(InvalidInputException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(ExistException.class)
  public ErrorResponse existException(ExistException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(BookNotFoundException.class)
  public ErrorResponse bookNotFoundException(BookNotFoundException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }
}
