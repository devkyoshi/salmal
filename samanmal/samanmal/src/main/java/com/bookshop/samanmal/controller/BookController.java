package com.bookshop.samanmal.controller;

import com.bookshop.samanmal.dto.BookRequestDTO;
import com.bookshop.samanmal.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> addBook(@RequestBody BookRequestDTO bookRequestDTO) {

        boolean isBookAdded = bookService.addNewBook(bookRequestDTO);

        if(isBookAdded){
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.badRequest().body(false);
    }


    //update

    //delete

    //get all books

    //get book by id


}


