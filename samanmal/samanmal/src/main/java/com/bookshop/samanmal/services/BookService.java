package com.bookshop.samanmal.services;


import com.bookshop.samanmal.dto.BookRequestDTO;
import com.bookshop.samanmal.models.Book;
import com.bookshop.samanmal.repository.BookRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public boolean addNewBook(BookRequestDTO bookRequestDTO) {
        try{
            Book book = new Book();

            //Check missing fields
            if(bookRequestDTO.getBookName() == null || bookRequestDTO.getAuthor() == null || bookRequestDTO.getGenre() == null || bookRequestDTO.getPublisher() == null || bookRequestDTO.getLanguage() == null || bookRequestDTO.getPrice() == 0) {
                log.error("Missing fields in the request");
                return false;
            }

            //Check if the book already exists
            if(bookRepository.existsBookByBookNameAndAuthor(bookRequestDTO.getBookName(), bookRequestDTO.getAuthor())) {
                log.error("Book already exists in the database");
                return false;
            }

            //If the book does not exist, add the book to the database

            //Set the book details
            book.setBookName(bookRequestDTO.getBookName());
            book.setAuthor(bookRequestDTO.getAuthor());
            book.setGenre(bookRequestDTO.getGenre());
            book.setPublisher(bookRequestDTO.getPublisher());
            book.setISBN(bookRequestDTO.getISBN());
            book.setLanguage(bookRequestDTO.getLanguage());
            book.setDescription(bookRequestDTO.getDescription());
            book.setBookImage(bookRequestDTO.getBookImage());
            book.setPrice(bookRequestDTO.getPrice());
            book.setCreatedDate(LocalDateTime.now());
            book.setUpdatedDate(LocalDateTime.now());

            //Save the book
            bookRepository.save(book);
            log.info("Book added successfully");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
