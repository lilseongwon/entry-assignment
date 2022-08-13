package com.example.entryassignment.domain.book.facade;

import com.example.entryassignment.domain.book.domain.ApplyList;
import com.example.entryassignment.domain.book.domain.repository.ApplyListReposiroty;
import com.example.entryassignment.domain.book.exception.AlreadyAppliedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ApplyListFacade {
    private final ApplyListReposiroty applyListRepository;

    public void checkApplyExist(String title, String isbn) {
        if (applyListRepository.findByIsbn(isbn).isPresent())
            throw AlreadyAppliedException.EXCEPTION;
    }
}
