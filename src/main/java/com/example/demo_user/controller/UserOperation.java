package com.example.demo_user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo_user.entity.User;
import com.example.demo_user.model.request.UserRequest;

public interface UserOperation {

  @GetMapping("/user/username/{name}")
  @ResponseStatus(HttpStatus.FOUND)
  public User getUser(@PathVariable String name);

  @PostMapping("/add/user")
  @ResponseStatus(HttpStatus.CREATED)
  public User addUser(@RequestBody UserRequest userRequest);
}
