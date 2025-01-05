package com.bookshop.samanmal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Table(name = "books")
@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String publisher;

    private String ISBN;

    @Column(nullable = false)
    private String language;

    private String description;
    private String bookImage; //URL of the book image

    @Column(nullable = false)
    private double price;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
