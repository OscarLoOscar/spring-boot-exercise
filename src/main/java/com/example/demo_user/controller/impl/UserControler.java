package com.example.demo_user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_user.controller.UserOperation;
import com.example.demo_user.entity.User;
import com.example.demo_user.exceptions.SysCode;
import com.example.demo_user.exceptions.user.UserNotFoundException;
import com.example.demo_user.model.request.UserRequest;
import com.example.demo_user.service.UserService;

@RestController
public class UserControler implements UserOperation {

  @Autowired
  private UserService userService;


  @Override
  public User getUser(String name) {
    if (userService.getUser(name).isPresent())
      return userService.getUser(name).get();
    else
      return userService.getUser(name).orElseThrow(
          () -> new UserNotFoundException(SysCode.USER_NOT_FOUND.getCode(),
              SysCode.USER_NOT_FOUND.getMessage()));
  }

  @Override
  public User addUser(UserRequest userRequest) {
    return userService.addUser(userRequest.getName(), userRequest.getEmail());
  }

}
