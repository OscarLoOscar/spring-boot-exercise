package com.example.demo_user.service;

import java.util.List;
import java.util.Optional;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;

public interface BookService {

  public Optional<Book> getBookByBookname(String bookName);

  public Optional<List<Book>> getBookByAuthor(String author);

  public List<Book> getBookList();

  public Book addBook(BookRequest bookRequest);

}
