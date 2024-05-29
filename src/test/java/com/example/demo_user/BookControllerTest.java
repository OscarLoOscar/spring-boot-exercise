package com.example.demo_user;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo_user.controller.impl.BookController;
import com.example.demo_user.entity.Book;
import com.example.demo_user.model.request.BookRequest;
import com.example.demo_user.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
class BookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BookService bookService;

  @Autowired
  private ObjectMapper objectMapper;

  private Book book;

  @BeforeEach
  void setUp() {
    book = new Book();
    book.setBookID(1);
    book.setAuthor("Author1");
    book.setBookName("Book1");
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getBookByBooknameTest() throws Exception {
    when(bookService.getBookByBookname(anyString()))
        .thenReturn(Optional.of(book));

    mockMvc.perform(get("/book/{bookname}", "Test Book"))
        .andExpect(status().isFound())
        .andExpect(jsonPath("$.bookName").value("Book1"));
  }

  @Test
  void getBookByBooknameNotFoundTest() throws Exception {
    when(bookService.getBookByBookname(anyString()))
        .thenReturn(Optional.empty());

    mockMvc.perform(get("/book/{bookname}", "Nonexistent Book"))
        .andExpect(status().isNotFound());
  }

  @Test
  void getBookListTest() throws Exception {
    when(bookService.getBookList()).thenReturn(Collections.singletonList(book));

    mockMvc.perform(get("/books")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].bookName").value("Book1"));
  }

  @Test
  void addBookTest() throws Exception {
    BookRequest bookRequest = BookRequest.builder()//
        .bookName("New Book")//
        .author("New Author")//
        .build();//

    when(bookService.addBook(Mockito.any(BookRequest.class))).thenReturn(book);

    mockMvc
        .perform(post("/book").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(bookRequest)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.bookName").value("Book1"));
  }

  @Test
  void getBookByAuthorTest() throws Exception {
    when(bookService.getBookByAuthor(anyString()))
        .thenReturn(Optional.of(Collections.singletonList(book)));

    mockMvc.perform(get("/author/{authorname}", "Test Author"))
        .andExpect(status().isFound())
        .andExpect(jsonPath("$[0].bookName").value("Book1"));
  }

  @Test
  void getBookByAuthorNotFoundTest() throws Exception {
    when(bookService.getBookByAuthor(anyString())).thenReturn(Optional.empty());

    mockMvc.perform(get("/author/{authorname}", "Nonexistent Author"))
        .andExpect(status().isNotFound());
  }
}
