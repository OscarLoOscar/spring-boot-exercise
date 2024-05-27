package com.example.demo_user.model.Dto;

import java.util.List;
import com.example.demo_user.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDTO {

  private int userID;
  private String userName;
  private List<Book> records;
}
