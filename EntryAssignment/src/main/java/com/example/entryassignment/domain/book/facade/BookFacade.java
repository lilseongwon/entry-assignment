package com.example.entryassignment.domain.book.facade;

import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.exception.AlreadyBookExistExcpetion;
import com.example.entryassignment.domain.book.exception.BookIsNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookFacade {

    private final BookRepository bookRepository;

    public void checkBookExist(String title, String isbn){
        if(bookRepository.findByTitleAndIsbn(title, isbn).isPresent())
            throw AlreadyBookExistExcpetion.EXCPETION;
    }

    public Book getBookByTitleAndIsbn(String title, String isbn){
        return bookRepository.findByTitleAndIsbn(title, isbn)
                .orElseThrow(() -> BookIsNotExistException.EXCEPTION);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> BookIsNotExistException.EXCEPTION);
    }
}