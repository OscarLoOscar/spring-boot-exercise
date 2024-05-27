package com.example.demo_user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserRequest {
  private int id;
  private String name;
  private String email;
}
