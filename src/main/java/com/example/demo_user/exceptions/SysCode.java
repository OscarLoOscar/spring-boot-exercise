package com.example.demo_user.exceptions;

import lombok.Getter;

@Getter
public enum SysCode {
  SUCCESS("000000", "Success"), //
  USER_NOT_FOUND("000001", "User not found"), //
  BOOK_NOT_FOUND("000002", "Book not found"), //
  USER_ALREADY_EXISTS("000003", "User already exists"), //
  BOOK_ALREADY_EXISTS("000004", "Book already exists"), //
  INTERNAL_SERVER_ERROR("000005", "Internal server error"), //
  INVALID_USER_ID("000009", "Invalid user id"), //
  INVALID_BOOK_ID("000010", "Invalid book id"), //
  INVALID_USER_NAME("000011", "Invalid user name"), //
  INVALID_BOOK_NAME("000012", "Invalid book name"), //
  INVALID_AUTHOR("000013", "Invalid author");//

  private final String code;
  private final String message;

  SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
