package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.exception.AlreadyBookExistExcpetion;
import com.example.entryassignment.domain.book.exception.NoPermissionException;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import com.example.entryassignment.global.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminAddBookService {
    private final UserFacade userFacade;
    private final BookRepository bookRepository;

    public String execute(AdminAddBookRequest request){
        if(!(Objects.equals(userFacade.getCurrentUser().getAccountId(), System.getenv("ADMIN"))))
            throw NoPermissionException.EXCEPTION;

        Optional<Book> book = bookRepository.findByTitleAndIsbn(request.getTitle(), request.getIsbn());
        if(book.isPresent())
            throw AlreadyBookExistExcpetion.EXCPETION;

        bookRepository.save(
                Book.builder()
                        .title(request.getTitle())
                        .picture(request.getPicture())
                        .author(request.getAuthor())
                        .isbn(request.getIsbn())
                        .publisher(request.getPublisher())
                        .genre(request.getGenre())
                        .build());

        return "도서 추가가 완료되었습니다.";
    }
}
