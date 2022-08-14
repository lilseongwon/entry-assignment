package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.apply.domain.ApplyList;
import com.example.entryassignment.domain.book.domain.Book;
import com.example.entryassignment.domain.apply.domain.repository.ApplyListReposiroty;
import com.example.entryassignment.domain.book.domain.repository.BookRepository;
import com.example.entryassignment.domain.book.facade.AdminFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.book.presentation.dto.request.AdminAddBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminAddBookService {
    private final AdminFacade adminFacade;
    private final BookFacade bookFacade;
    private final BookRepository bookRepository;
    private final ApplyListReposiroty applyListReposiroty;

    public String execute(AdminAddBookRequest request){

        adminFacade.checkPermission();

        bookFacade.checkBookExist(request.getIsbn());

        bookRepository.save(
                Book.builder()
                        .title(request.getTitle())
                        .picture(request.getPicture())
                        .author(request.getAuthor())
                        .isbn(request.getIsbn())
                        .publisher(request.getPublisher())
                        .genre(request.getGenre())
                        .build());

        if (applyListReposiroty.findByIsbn(request.getIsbn()).isPresent()){
            ApplyList applyList = applyListReposiroty.findApplyListByIsbn(request.getIsbn());

            applyListReposiroty.delete(applyList);
        }

        return "도서 추가가 완료되었습니다.";
    }
}
