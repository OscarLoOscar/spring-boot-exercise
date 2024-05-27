package com.example.demo_user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.demo_user.entity.User;
import com.example.demo_user.exceptions.book.BookExistException;
import com.example.demo_user.exceptions.user.UserExistException;

@Component
public class UserRepository {
  private static List<User> users = new ArrayList<>();

  public Optional<User> getUser(String name) {
    return users.stream()//
        .filter(u -> u.getName().equals(name))//
        .findFirst();
  }

  public User addUser(String name, String email) throws UserExistException {
    users.stream().filter(e -> e.getName().equals(name)).findFirst()
        .orElseThrow(() -> new UserExistException(name, email));
    User user = new User(name, email);
    users.add(user);
    return user;
  }

}
