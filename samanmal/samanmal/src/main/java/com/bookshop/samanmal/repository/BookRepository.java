package com.bookshop.samanmal.repository;

import com.bookshop.samanmal.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
     boolean existsBookByBookNameAndAuthor(String bookName, String author);
}
