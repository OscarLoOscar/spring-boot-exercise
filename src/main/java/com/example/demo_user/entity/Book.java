package com.example.demo_user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class Book {
  public static int counter = 0;
  private int bookID;
  private String bookName;
  private String author;

  public Book(String bookName,String author) {
    this.bookID = ++counter;
    this.bookName = bookName;
    this.author=author;
  }
}
