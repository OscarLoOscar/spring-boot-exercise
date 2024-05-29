package com.example.demo_user;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo_user.controller.impl.UserController;
import com.example.demo_user.entity.User;
import com.example.demo_user.model.request.UserRequest;
import com.example.demo_user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Autowired
  private ObjectMapper objectMapper;

  private User user;

  @BeforeEach
  void setUp() {
    user = User.builder()//
        .userID(1)//
        .name("User1")//
        .email("abc@abc.com")//
        .build();

  }

  @Test
  void getUserTest() throws Exception {
    when(userService.getUser(anyString()))//
        .thenReturn(Optional.of(user));

    mockMvc.perform(get("/user/username/{name}", "Test User"))
        .andExpect(status().isFound())//
        .andExpect(jsonPath("$.name").value("User1"))//
        .andExpect(jsonPath("$.email").value("abc@abc.com"));
  }

  @Test
  void getUserNotFoundTest() throws Exception {
    mockMvc.perform(get("/user/username/{name}", "Test User"))
        .andExpect(status().isNotFound());
  }

  @Test
  void addUserTest() throws Exception {
    UserRequest userRequest = UserRequest.builder()//
        .name("User1")//
        .email("abc@abc.com")//
        .build();

    when(userService.addUser(anyString(), anyString()))//
        .thenReturn(user);

    mockMvc.perform(post("/add/user")//
        .contentType(MediaType.APPLICATION_JSON)//
        .content(objectMapper.writeValueAsString(userRequest)))//
        .andExpect(status().isCreated())//
        .andExpect(jsonPath("$.name").value("User1"))//
        .andExpect(jsonPath("$.email").value("abc@abc.com"));

  }
}
