package com.example.demo_user;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class BookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private BookService bookService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetBookByBookname() throws Exception {
    String bookname = "Book1";
    Book book = new Book();
    book.setBookName(bookname);
    when(bookService.getBookByBookname(bookname)).thenReturn(Optional.of(book));

    mockMvc.perform(get("/book/{bookname}", bookname))
        .andExpect(status().isFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.bookName", is(bookname)));
  }


  @Test
  public void testGetBookByBookname_NotFound() throws Exception {
    String bookname = "NonExistingBook";
    when(bookService.getBookByBookname(bookname)).thenReturn(Optional.empty());

    mockMvc.perform(get("/book/{bookname}", bookname))
        .andExpect(status().isBadRequest())//
        .andExpect(result -> {
          result.getResolvedException();
        });
  }

  @Test
  public void testGetBookList() throws Exception {
    List<Book> expectedBooks = Arrays.asList(new Book("Book1", "Author1"),
        new Book("Book2", "Author2"));
    when(bookService.getBookList())//
        .thenReturn(expectedBooks);

    mockMvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON)//
        .content(objectMapper.writeValueAsString(expectedBooks)))//
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].bookName", is("Book1")))
        .andExpect(jsonPath("$[1].bookName", is("Book2")));
  }

  @Test
  public void testAddBook() throws Exception {
    BookRequest bookRequest = BookRequest.builder()//
        .bookName("Book1")//
        .author("Author1")//
        .build();
    Book expectedBook = Book.builder()//
        .bookName("Book1")//
        .author("Author1")//
        .build();
    expectedBook.setBookID(1);

    when(bookService.addBook(bookRequest))//
        .thenReturn(expectedBook);

    mockMvc.perform(post("/book")//
        .contentType(APPLICATION_JSON)//
        .accept(APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(bookRequest)))//
        .andDo(print()) //
        .andExpect(status().isCreated())//
        .andExpect(jsonPath("$.bookID", is(1)))//
        .andExpect(jsonPath("$.author", is("Author1")))//
        .andExpect(jsonPath("$.bookName", is("Book1")))//
        .andExpect(content().json(
            "{\"bookID\":1,\"bookName\":\"Book1\",\"author\":\"Author1\"}"));
  }

  @Test
  public void testGetBookByAuthor() throws Exception {
    String author = "Author1";
    List<Book> expectedBooks =
        Arrays.asList(new Book("Book1", author), new Book("Book2", author));
    when(bookService.getBookByAuthor(author))
        .thenReturn(Optional.of(expectedBooks));

    mockMvc.perform(get("/author/{authorname}", author))
        .andExpect(status().isFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].author", is("Author1")))
        .andExpect(jsonPath("$[1].author", is("Author1")));
  }

  @Test
  public void testGetBookByAuthor_NotFound() throws Exception {
    String author = "NonExistingAuthor";
    when(bookService.getBookByAuthor(author)).thenReturn(Optional.empty());

    mockMvc.perform(get("/author/{authorname}", author))
        .andExpect(status().is4xxClientError()).andExpect(result -> {
          result.getResolvedException();
        });
  }

}
