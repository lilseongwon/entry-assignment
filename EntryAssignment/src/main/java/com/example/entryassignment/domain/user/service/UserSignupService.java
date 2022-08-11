package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.domain.repository.UserRepository;
import com.example.entryassignment.domain.user.exception.UserExistException;
import com.example.entryassignment.domain.user.presentation.dto.request.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String execute(SignupRequestDto requestDto) {
        Optional<User> user = userRepository.findByAccountId(requestDto.getAccountId());
        if (user.isPresent())
            throw UserExistException.EXCEPTION;

        userRepository.save(
                User.builder()
                        .accountId(requestDto.getAccountId())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .name(requestDto.getName())
                        .build());
        return "회원가입이 완료되었습니다.";
    }
}
