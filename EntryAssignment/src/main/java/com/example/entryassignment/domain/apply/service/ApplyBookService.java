package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyReposiroty;
import com.example.entryassignment.domain.apply.facade.ApplyFacade;
import com.example.entryassignment.domain.book.facade.BookFacade;
import com.example.entryassignment.domain.book.presentation.dto.request.ApplyBookRequest;
import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplyBookService {

    private final BookFacade bookFacade;
    private final UserFacade userFacade;
    private final ApplyFacade applyFacade;
    private final ApplyReposiroty applyReposiroty;

    public String execute(ApplyBookRequest request) {
        bookFacade.checkBookExist(request.getIsbn());

        applyFacade.checkApplyExist(request.getIsbn());

        User user = userFacade.getCurrentUser();

        applyReposiroty.save(
                Apply.builder()
                        .title(request.getTitle())
                        .isbn(request.getIsbn())
                        .user(user)
                        .build());

        return "도서 신청이 완료되었습니다.";
    }
}
