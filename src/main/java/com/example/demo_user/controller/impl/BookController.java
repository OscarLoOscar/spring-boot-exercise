package com.example.demo_user.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_user.controller.BookOperation;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.service.BookService;

@RestController
public class BookController implements BookOperation {

  @Autowired
  private BookService bookService;

  @Override
  public Book getBookByBookname(String bookname) {
    if (bookService.getBookByBookname(bookname).isPresent())
      return bookService.getBookByBookname(bookname).get();
    else
      return bookService.getBookByBookname(bookname)
          .orElseThrow(() -> new RuntimeException("book is not exist"));
  }

  @Override
  public List<Book> getBookList() {
    return bookService.getBookList();
  }

  @Override
  public Book addBook(BookRequest bookRequest) {
    return bookService.addBook(bookRequest);
  }

  @Override
  public List<Book> getBookByAuthor(String arthur) {
    if (bookService.getBookByAuthor(arthur).isPresent())
      return bookService.getBookByAuthor(arthur).get();
    else
      return bookService.getBookByAuthor(arthur)
          .orElseThrow(() -> new RuntimeException("book is not exist"));
  }

}
