package com.example.demo_user;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo_user.entity.User;
import com.example.demo_user.exceptions.user.UserExistException;
import com.example.demo_user.model.request.UserRequest;
import com.example.demo_user.service.UserService;

@SpringBootTest
public class UserServiceImplTest {
  @Autowired
  private UserService userService;

  @BeforeEach
  void setUp() {
    userService.getAllUser().clear();
  }

  @Test
  void testAddUser() {
    UserRequest userRequest = UserRequest.builder()//
        .name("User")//
        .email("abc.def@abc.com")//
        .build();

    UserRequest userRequest2 = UserRequest.builder()//
        .name("User2")//
        .email("abc.def@abc.com")//
        .build();

    UserRequest userRequest3 = UserRequest.builder()//
        .name("User")//
        .email("xyz.abc@xyz.com")//
        .build();

    User user =
        userService.addUser(userRequest.getName(), userRequest.getEmail());

    assertThrows(UserExistException.class, () -> {
      userService.addUser(userRequest2.getName(), userRequest2.getEmail());
    });

    assertThrows(UserExistException.class, () -> {
      userService.addUser(userRequest3.getName(), userRequest3.getEmail());
    });

    assertNotNull(user);
    assertEquals("User", user.getName());
    assertEquals("abc.def@abc.com", user.getEmail());


  }

  @Test
  void testGetUser() {
    UserRequest userRequest = UserRequest.builder()//
        .name("User")//
        .email("abc@abc.com")//
        .build();

    userService.addUser(userRequest.getName(), userRequest.getEmail());
    assertTrue(userService.getUser("User").isPresent());
  }

  @Test
  void testGetAllUser() {
    UserRequest userRequest = UserRequest.builder()//
        .name("User")//
        .email("abc.def@abc.com")//
        .build();
    User user =
        userService.addUser(userRequest.getName(), userRequest.getEmail());

    UserRequest userRequest2 = UserRequest.builder()//
        .name("User2")//
        .email("abc.hjk@abc.com")//
        .build();
    User user2 =
        userService.addUser(userRequest2.getName(), userRequest2.getEmail());

    UserRequest userRequest3 = UserRequest.builder()//
        .name("User3")//
        .email("xyz.abc@xyz.com")//
        .build();
    User user3 =
        userService.addUser(userRequest3.getName(), userRequest3.getEmail());

    assertEquals(3, userService.getAllUser().size());
  }
}
