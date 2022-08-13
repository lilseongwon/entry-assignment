package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.facade.AdminFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteBookService {

    private final AdminFacade adminFacade;
    private final BookFacade bookFacade;
    private final BookRepository bookRepository;

    public String execute(Long id){
        adminFacade.checkPermission();

        bookRepository.delete(bookFacade.getBookById(id));

        return "도서 삭제가 완료되었습니다.";
    }
}
