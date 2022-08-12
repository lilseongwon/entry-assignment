package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.domain.repository.UserRepository;
import com.example.entryassignment.domain.user.exception.PasswordMismatchException;
import com.example.entryassignment.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.entryassignment.global.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public String execute(UpdatePasswordRequest request) {
        User user = userFacade.getCurrentUser();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.changePassword(request.getNewPassword());

        return "비밀번호 변경이 완료되었습니다.";
    }
}
