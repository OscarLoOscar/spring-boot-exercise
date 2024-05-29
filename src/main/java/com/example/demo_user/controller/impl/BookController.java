package com.example.demo_user.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_user.controller.BookOperation;
import com.example.demo_user.entity.Book;
import com.example.demo_user.exceptions.SysCode;
import com.example.demo_user.exceptions.book.BookNotFoundException;
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
      return bookService.getBookByBookname(bookname).orElseThrow(
          () -> new BookNotFoundException(SysCode.BOOK_NOT_FOUND.getCode(),
              SysCode.BOOK_NOT_FOUND.getMessage()));
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
  public List<Book> getBookByAuthor(String authorname) {
    if (bookService.getBookByAuthor(authorname).isPresent())
      return bookService.getBookByAuthor(authorname).get();
    else
      return bookService.getBookByAuthor(authorname).orElseThrow(
          () -> new BookNotFoundException(SysCode.INVALID_AUTHOR.getCode(),
              SysCode.INVALID_AUTHOR.getMessage()));
  }

}
