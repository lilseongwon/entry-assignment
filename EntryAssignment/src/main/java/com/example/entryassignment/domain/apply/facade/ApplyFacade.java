package com.example.entryassignment.domain.apply.facade;

import com.example.entryassignment.domain.apply.domain.Apply;
import com.example.entryassignment.domain.apply.domain.repository.ApplyRepository;
import com.example.entryassignment.domain.apply.exception.AlreadyAppliedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class ApplyFacade {
    private final ApplyRepository applyRepository;

    public void checkApplyExist(Integer isbn) {
        if (applyRepository.findByIsbn(isbn).isPresent())
            throw AlreadyAppliedException.EXCEPTION;
    }

    public Apply getApplyBy(Integer isbn) {
        return applyRepository.findApplyByIsbn(isbn);
    }
}
