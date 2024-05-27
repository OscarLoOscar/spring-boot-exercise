package com.example.demo_user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {
  public static int counter = 0;
  private int id;
  private String name;
  private String email;

  public User(String name,String email) {
    this.id = ++counter;
    this.name = name;
    this.email=email;
  }
}
