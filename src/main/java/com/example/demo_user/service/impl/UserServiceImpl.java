package com.example.demo_user.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_user.entity.User;
import com.example.demo_user.repository.UserRepository;
import com.example.demo_user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public Optional<User> getUser(String name) {
    return userRepository.getUser(name);
  }

  @Override
  public User addUser(String name, String email) {
    return userRepository.addUser(name, email);
  }

  @Override
  public List<User> getAllUser() {
    return userRepository.getUserList();
  }
}
