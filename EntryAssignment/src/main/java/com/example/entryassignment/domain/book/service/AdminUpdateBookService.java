package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.book.facade.AdminFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminUpdateBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminUpdateBookService {

    private final AdminFacade adminFacade;
    private final BookFacade bookFacade;

    @Transactional
    public String execute(AdminUpdateBookRequest request){
        adminFacade.checkPermission();

        Book book = bookFacade.getBookByTitleAndIsbn(request.getTitle(), request.getIsbn());

        book.update(request.getTitle(), request.getPicture(), request.getAuthor(),
                request.getIsbn(), request.getPublisher(), request.getGenre());

        return "도서 수정이 완료되었습니다.";
    }
}
