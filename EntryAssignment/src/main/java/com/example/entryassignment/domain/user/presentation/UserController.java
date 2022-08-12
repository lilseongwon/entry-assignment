package com.example.entryassignment.domain.user.presentation;

import com.example.entryassignment.domain.user.service.QueryMyInformationService;
import com.example.entryassignment.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.entryassignment.domain.user.presentation.dto.response.QueryMyInformationResponse;
import com.example.entryassignment.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final QueryMyInformationService queryMyInformationService;

    @PostMapping("/signup")
    public String userSignup(@RequestBody @Valid UserSignupRequest request) {
        return userSignupService.execute(request);
    }

    @GetMapping("/info")
    public QueryMyInformationResponse queryMyInformation() {
        return queryMyInformationService.execute();
    }

}

