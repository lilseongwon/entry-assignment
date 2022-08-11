package com.example.entryassignment.domain.auth.presentation;

import com.example.entryassignment.domain.auth.presentation.dto.request.SignInRequestDto;
import com.example.entryassignment.domain.auth.presentation.dto.response.TokenResponse;
import com.example.entryassignment.domain.auth.service.TokenRefreshService;
import com.example.entryassignment.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserSignInService userSignInService;
    private final TokenRefreshService tokenRefreshService;

    @PostMapping("/token")
    public TokenResponse userSignIn(@RequestBody @Valid SignInRequestDto signInRequestDto) {
        return userSignInService.execute(signInRequestDto);
    }
    @PatchMapping
    public TokenResponse Reisssu(@RequestHeader("Refresh-Token") String refreshToken){
        return tokenRefreshService.execute(refreshToken);
    }
}
