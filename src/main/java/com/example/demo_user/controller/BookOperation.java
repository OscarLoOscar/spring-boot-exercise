package com.example.demo_user.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;

public interface BookOperation {

  @GetMapping("/book/{bookname}")
  @ResponseStatus(HttpStatus.FOUND)
  public Book getBookByBookname(@PathVariable String bookname);

  @GetMapping("/author/{authorname}")
  @ResponseStatus(HttpStatus.FOUND)
  public List<Book> getBookByAuthor(@PathVariable String authorname);

  @GetMapping("/books")
  @ResponseStatus(HttpStatus.OK)
  public List<Book> getBookList();

  @PostMapping(value = "/book", //
      consumes = MediaType.APPLICATION_JSON_VALUE//
      , produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Book addBook(@RequestBody BookRequest bookRequest);

}
