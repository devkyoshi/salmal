package com.bookshop.samanmal.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class BookRequestDTO {
    private String bookName;
    private String author;
    private String genre;
    private String publisher;
    private String ISBN;
    private String language;
    private String description;
    private String bookImage; //URL of the book image
    private double price;
}
