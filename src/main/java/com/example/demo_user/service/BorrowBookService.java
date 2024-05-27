package com.example.demo_user.service;

import java.util.List;
import com.example.demo_user.model.Dto.UserDTO;

public interface BorrowBookService {
    
    public boolean borrowBook(String bookname, String username);
    
    public UserDTO getRecord(String username);

    public List<UserDTO> getAllRecord();
}
