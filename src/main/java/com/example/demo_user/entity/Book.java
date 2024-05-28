package com.example.demo_user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Book {
  @JsonProperty("bookID")
  private int bookID;
  @JsonProperty("bookName")
  private String bookName;
  @JsonProperty("author")
  private String author;

  public Book(String bookName, String author) {
    this.bookName = bookName;
    this.author = author;
  }

  public int getBookID() {
    return bookID;
  }

  public void setBookID(int bookID) {
    this.bookID = bookID;
  }
}
