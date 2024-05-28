package com.example.demo_user.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo_user.model.Dto.UserDTO;

public interface BorrowBookOperation {
  @PostMapping("/borrowbooks/username/{name}")
  @ResponseStatus(HttpStatus.CREATED)
  public boolean borrowBooks(@PathVariable String name,
      @RequestParam String bookname);

  @GetMapping("/record")
  @ResponseStatus(HttpStatus.FOUND)
  public UserDTO getRecord(@RequestParam String name);

  @GetMapping("/allrecord")
  @ResponseStatus(HttpStatus.FOUND)
  public List<UserDTO> getAllRecord();
}
