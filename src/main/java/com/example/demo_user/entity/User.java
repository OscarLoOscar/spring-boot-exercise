package com.example.demo_user.entity;

import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {
  public static int counter = 0;
  private int userID;
  @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
      message = "username must be of 6 to 12 length with no special characters")
  private String name;

  // @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
  // message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
  // private String password;

  @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
      message = "email must be of valid format")
  private String email;

  public User(String name, String email) {
    this.userID = ++counter;
    this.name = name;
    this.email = email;
  }
}
