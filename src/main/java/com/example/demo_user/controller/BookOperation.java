package com.example.demo_user.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;

public interface BookOperation {

  @GetMapping("/get/bookname/{bookname}")
  public Book getBookByBookname(@PathVariable String bookname);

  @GetMapping("/get/bookname/{arthurname}")
  public List<Book> getBookByAuthor(@PathVariable String arthur);

  @GetMapping("/get/booklist")
  public List<Book> getBookList();

  @PostMapping("/add/book")
  public Book addBook(@RequestBody BookRequest bookRequest);

}
