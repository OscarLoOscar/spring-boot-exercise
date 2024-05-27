package com.example.demo_user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_user.entity.Book;
import com.example.demo_user.entity.User;
import com.example.demo_user.model.Dto.UserDTO;
import com.example.demo_user.service.BookService;
import com.example.demo_user.service.BorrowBookService;
import com.example.demo_user.service.UserService;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {
  private static Map<User, List<Book>> booksRecords = new HashMap<>();
  
  @Autowired
  private BookService bookService;

  @Autowired
  private UserService userService;

  // @Override
  // public boolean borrowBook(String name, String bookname) {
  // List<Book> booklist = new ArrayList<>();
  // if (userService.getUser(name).isPresent()
  // && bookService.getBook(bookname).isPresent()) {
  // User user = userService.getUser(name).get();
  // Book book = bookService.getBook(bookname).get();
  // booklist.add(book);
  // booksRecords.put(user, booklist);
  // return true;
  // }
  // return false;
  // }

  @Override
  public boolean borrowBook(String name, String bookname) {
    Optional<User> optionalUser = userService.getUser(name);
    Optional<Book> optionalBook = bookService.getBookByBookname(bookname);
    if (optionalUser.isPresent() && optionalBook.isPresent()) {
      User user = optionalUser.get();
      Book book = optionalBook.get();
      List<Book> booklist = booksRecords.getOrDefault(user, new ArrayList<>());
      booklist.add(book);
      booksRecords.put(user, booklist);
      return true;
    }
    return false;
  }


  @Override
  public UserDTO getRecord(String name) {
    User user = userService.getUser(name).get();
    return UserDTO.builder()//
        .userID(user.getId())//
        .userName(user.getName())//
        .records(booksRecords.get(userService.getUser(name).get()))//
        .build();
  }


  @Override
  public List<UserDTO> getAllRecord() {
    return booksRecords.entrySet().stream()//
        .map(entry -> UserDTO.builder()//
            .userID(entry.getKey().getId())//
            .userName(entry.getKey().getName())//
            .records(entry.getValue())//
            .build())//
        .toList();
  }

}
