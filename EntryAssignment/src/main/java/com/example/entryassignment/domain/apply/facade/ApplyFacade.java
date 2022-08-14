package com.example.entryassignment.domain.apply.facade;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyReposiroty;
import com.example.entryassignment.domain.apply.exception.AlreadyAppliedException;
import com.example.entryassignment.global.error.CustomException;
import com.example.entryassignment.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ApplyFacade {
    private final ApplyReposiroty applyRepository;

    public void checkApplyExist(String isbn) {
        if (applyRepository.findByIsbn(isbn).isPresent())
            throw AlreadyAppliedException.EXCEPTION;
    }

    public Apply getApplyBy(String isbn) {
        return applyRepository.findByIsbn(isbn)
                .orElseThrow(() -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}