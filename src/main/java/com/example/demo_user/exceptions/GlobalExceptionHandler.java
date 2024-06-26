package com.example.demo_user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo_user.exceptions.book.BookNotFoundException;
import com.example.demo_user.exceptions.user.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse notFoundException(NotFoundException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse invalidInputException(InvalidInputException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(ExistException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse existException(ExistException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(BookNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse bookNotFoundException(BookNotFoundException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse userNotFoundException(UserNotFoundException e) {
    return new ErrorResponse(e.getCode(), e.getMessage());
  }
}
