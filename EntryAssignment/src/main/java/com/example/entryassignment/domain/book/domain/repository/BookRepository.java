package com.example.entryassignment.domain.book.domain.repository;

import com.example.entryassignment.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleAndIsbn(String title, String isbn);
}