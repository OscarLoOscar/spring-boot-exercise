package com.example.demo_user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.repository.BookRepository;
import com.example.demo_user.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;



  @Override
  public Optional<Book> getBookByBookname(String bookName) {
    return bookRepository.getBookByBookname(bookName);
  }

  @Override
  public List<Book> getBookList() {
    return bookRepository.getBookList();
  }

  @Override
  public Book addBook(BookRequest bookRequest) {
    Book book = new Book(bookRequest.getBookName(), bookRequest.getAuthor());
    return bookRepository.addBook(book);
  }


  @Override
  public Optional<List<Book>> getBookByAuthor(String author) {
    return bookRepository.getBookByAuthor(author);
  }


}
