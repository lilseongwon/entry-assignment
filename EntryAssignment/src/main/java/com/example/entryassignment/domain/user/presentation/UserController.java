package com.example.entryassignment.domain.user.presentation;

import com.example.entryassignment.domain.user.presentation.dto.request.SignupRequestDto;
import com.example.entryassignment.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        return userSignupService.execute(signupRequestDto);
    }
