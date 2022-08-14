package com.example.entryassignment.domain.book.facade;

import com.example.entryassignment.domain.apply.domain.repository.ApplyListReposiroty;
import com.example.entryassignment.domain.apply.exception.AlreadyAppliedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ApplyListFacade {
    private final ApplyListReposiroty applyListRepository;

    public void checkApplyExist(String isbn) {
        if (applyListRepository.findByIsbn(isbn).isPresent())
            throw AlreadyAppliedException.EXCEPTION;
    }
}
