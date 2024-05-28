package com.example.demo_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.repository.BookRepository;
import com.example.demo_user.service.impl.BookServiceImpl;

public class BookServiceImplTest {

  @InjectMocks
  private BookServiceImpl bookService;

  @Mock
  private BookRepository bookRepository;
  
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  public void testGetBookByBookname() {
    String bookName = "Book1";
    Book book = new Book(bookName, "Author1");
    when(bookRepository.getBookByBookname(bookName)).thenReturn(Optional.of(book));

    Optional<Book> result = bookService.getBookByBookname(bookName);

    assertTrue(result.isPresent());
    assertEquals(book, result.get());
  }

  @Test
  public void testGetBookList() {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book1", "Author1"));
    books.add(new Book("Book2", "Author2"));
    when(bookRepository.getBookList()).thenReturn(books);

    List<Book> result = bookService.getBookList();

    assertEquals(books, result);
  }

  @Test
  public void testAddBook() {
    BookRequest bookRequest = new BookRequest("Book1", "Author1");
    Book book = new Book(bookRequest.getBookName(), bookRequest.getAuthor());
    book.setBookID(1);
    when(bookRepository.addBook(book)).thenReturn(book);

    Book result = bookService.addBook(bookRequest);

    assertEquals(book, result);
  }

  @Test
  public void testGetBookByAuthor() {
    String author = "Author1";
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book1", author));
    books.add(new Book("Book2", author));
    when(bookRepository.getBookByAuthor(author)).thenReturn(Optional.of(books));

    Optional<List<Book>> result = bookService.getBookByAuthor(author);

    assertTrue(result.isPresent());
    assertEquals(books, result.get());
  }
}