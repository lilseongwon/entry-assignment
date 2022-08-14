package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.ApplyList;
import com.example.entryassignment.domain.apply.domain.repository.ApplyListReposiroty;
import com.example.entryassignment.domain.book.facade.ApplyListFacade;
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
    private final ApplyListFacade applyListFacade;
    private final ApplyListReposiroty applyListReposiroty;

    public String execute(ApplyBookRequest request) {
        bookFacade.checkBookExist(request.getIsbn());

        applyListFacade.checkApplyExist(request.getIsbn());

        User user = userFacade.getCurrentUser();

        applyListReposiroty.save(
                ApplyList.builder()
                        .title(request.getTitle())
                        .isbn(request.getIsbn())
                        .user(user)
                        .build());

        return "도서 신청이 완료되었습니다.";
    }
}
