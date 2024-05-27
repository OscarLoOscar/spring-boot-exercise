package com.example.demo_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo_user.controller.impl.BookController;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.service.BookService;

public class BookControllerTest {

  @InjectMocks
  private BookController bookController;

  @Mock
  private BookService bookService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetBookByBookname() {
    String bookname = "Book1";
    Book book = new Book();
    book.setBookName(bookname);
    when(bookService.getBookByBookname(bookname)).thenReturn(Optional.of(book));

    Book result = bookController.getBookByBookname(bookname);

    assertEquals(book, result);
  }

  @Test
  public void testGetBookByBookname_NotFound() {
    String bookname = "NonExistingBook";
    when(bookService.getBookByBookname(bookname)).thenReturn(Optional.empty());

    RuntimeException exception = assertThrows(RuntimeException.class,
        () -> bookController.getBookByBookname(bookname));

    assertEquals("book is not exist", exception.getMessage());
  }

  @Test
  public void testGetBookList() {
    List<Book> expectedBooks = Arrays.asList(new Book(), new Book());
    when(bookService.getBookList()).thenReturn(expectedBooks);

    List<Book> result = bookController.getBookList();

    assertEquals(expectedBooks, result);
  }

  @Test
  public void testAddBook() {
    BookRequest bookRequest = new BookRequest();
    Book expectedBook = new Book();
    when(bookService.addBook(bookRequest)).thenReturn(expectedBook);

    Book result = bookController.addBook(bookRequest);

    assertEquals(expectedBook, result);
  }

  @Test
  public void testGetBookByAuthor() {
    String author = "Author1";
    List<Book> expectedBooks = Arrays.asList(new Book(), new Book());
    when(bookService.getBookByAuthor(author))
        .thenReturn(Optional.of(expectedBooks));

    List<Book> result = bookController.getBookByAuthor(author);

    assertEquals(expectedBooks, result);
  }

  @Test
  public void testGetBookByAuthor_NotFound() {
    String author = "NonExistingAuthor";
    when(bookService.getBookByAuthor(author)).thenReturn(Optional.empty());

    RuntimeException exception = assertThrows(RuntimeException.class,
        () -> bookController.getBookByAuthor(author));

    assertEquals("book is not exist", exception.getMessage());
  }
}
