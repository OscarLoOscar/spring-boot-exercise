package com.example.demo_user.service;

import java.util.List;
import java.util.Optional;
import com.example.demo_user.entity.User;

public interface UserService {

  public Optional<User> getUser(String name);

  public User addUser(String name,String email);

  public List<User> getAllUser();
}
