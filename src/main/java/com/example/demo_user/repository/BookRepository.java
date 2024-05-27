package com.example.demo_user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.demo_user.entity.Book;

@Component
public class BookRepository {

  private static List<Book> books = new ArrayList<>();

  public Optional<Book> getBookByBookname(String bookName) {
    return books.stream()//
        .filter(b -> b.getBookName().equals(bookName))//
        .findFirst();
  }

  public Optional<List<Book> > getBookByAuthor(String author) {
    return Optional.of(books.stream()//
        .filter(b -> b.getAuthor().equals(author))//
        .toList());
  }

  public List<Book> getBookList() {
    return books;
  }

  public Book addBook(String bookName,String author) {
    Book book = new Book(bookName,author);
    books.add(book);
    return book;
  }

}
