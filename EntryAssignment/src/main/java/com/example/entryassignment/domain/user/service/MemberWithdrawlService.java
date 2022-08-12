package com.example.entryassignment.domain.user.service;

import com.example.entryassignment.domain.user.domain.User;
import com.example.entryassignment.domain.user.domain.repository.UserRepository;
import com.example.entryassignment.global.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWithdrawlService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public String execute(){
        User user = userFacade.getCurrentUser();

        userRepository.delete(user);
        return "회원탈퇴가 완료되었습니다.";
    }
}