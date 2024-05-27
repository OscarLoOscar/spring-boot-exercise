package com.example.demo_user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo_user.entity.User;
import com.example.demo_user.model.request.UserRequest;

public interface UserOperation {

  @GetMapping("/user/username/{name}")
  public User getUser(@PathVariable String name);

  @PostMapping("/add/user")
  public User addUser(@RequestBody UserRequest userRequest);
}
