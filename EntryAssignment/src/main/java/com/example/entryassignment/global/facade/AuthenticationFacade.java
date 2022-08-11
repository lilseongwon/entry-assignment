package com.example.entryassignment.global.facade;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.domain.repository.UserRepository;
import com.example.entryassignment.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {

        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}