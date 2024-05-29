package com.example.demo_user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.service.BookService;

@SpringBootTest
public class BookServiceImplTest {

  @Autowired
  private BookService bookService;

  @BeforeEach
  void setUp() {
    // 清理存儲庫中的所有書籍，以確保測試之間不會相互干擾
    bookService.getBookList().clear();
  }

  @Test
  void testAddBook() {
    BookRequest bookRequest = new BookRequest();
    bookRequest.setBookName("Test Book");
    bookRequest.setAuthor("Test Author");

    Book book = bookService.addBook(bookRequest);

    assertNotNull(book);
    assertEquals("Test Book", book.getBookName());
    assertEquals("Test Author", book.getAuthor());
  }

  @Test
  void testGetBookByBookname() {
    BookRequest bookRequest = new BookRequest();
    bookRequest.setBookName("Test Book");
    bookRequest.setAuthor("Test Author");
    bookService.addBook(bookRequest);

    Optional<Book> book = bookService.getBookByBookname("Test Book");

    assertTrue(book.isPresent());
    assertEquals("Test Book", book.get().getBookName());
    assertEquals("Test Author", book.get().getAuthor());
  }

  @Test
  void testGetBookList() {
    BookRequest bookRequest1 = new BookRequest();
    bookRequest1.setBookName("Test Book 1");
    bookRequest1.setAuthor("Test Author 1");

    BookRequest bookRequest2 = new BookRequest();
    bookRequest2.setBookName("Test Book 2");
    bookRequest2.setAuthor("Test Author 2");

    bookService.addBook(bookRequest1);
    bookService.addBook(bookRequest2);

    List<Book> bookList = bookService.getBookList();

    assertEquals(2, bookList.size());
  }

  @Test
  void testGetBookByAuthor() {
    BookRequest bookRequest = new BookRequest();
    bookRequest.setBookName("Test Book");
    bookRequest.setAuthor("Test Author");
    bookService.addBook(bookRequest);

    Optional<List<Book>> booksByAuthor =
        bookService.getBookByAuthor("Test Author");

    assertTrue(booksByAuthor.isPresent());
    assertEquals(1, booksByAuthor.get().size());
    assertEquals("Test Author", booksByAuthor.get().get(0).getAuthor());
  }
}
