package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.domain.repository.UserRepository;
import com.example.entryassignment.domain.user.exception.UserExistException;
import com.example.entryassignment.domain.user.facade.UserFacade;
import com.example.entryassignment.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public String execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getAccountId());

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build());
        return "회원가입이 완료되었습니다.";
    }
}
