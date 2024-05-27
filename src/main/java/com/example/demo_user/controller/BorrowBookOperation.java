package com.example.demo_user.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo_user.model.Dto.UserDTO;

public interface BorrowBookOperation {
  @PostMapping("/borrowbooks/username/{name}")
  public boolean borrowBooks(@PathVariable String name,
      @RequestParam String bookname);

  @GetMapping("/record")
  public UserDTO getRecord(@RequestParam String name);

  @GetMapping("/allrecord")
  public List<UserDTO> getAllRecord();
}
