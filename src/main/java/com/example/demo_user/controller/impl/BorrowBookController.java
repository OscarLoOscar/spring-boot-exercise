package com.example.demo_user.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_user.controller.BorrowBookOperation;
import com.example.demo_user.model.Dto.UserDTO;
import com.example.demo_user.service.BorrowBookService;

@RestController
public class BorrowBookController implements BorrowBookOperation {

  @Autowired
  private BorrowBookService borrowBookService;

  @Override
  public boolean borrowBooks(String name, String bookname) {
    return borrowBookService.borrowBook(name, bookname);
  }

  @Override
  public UserDTO getRecord(String name) {
    return borrowBookService.getRecord(name);
  }

  @Override
  public List<UserDTO> getAllRecord() {
    return borrowBookService.getAllRecord();
  }

}
