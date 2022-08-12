package com.example.entryassignment.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@NotBlank
public class UserSignupRequest {

    @NotBlank(message = "아이디는 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "^[a-z0-9-_]{8,20}$", message = "아이디는 영어와 숫자를 조합한 8~20자리여야 합니다.")
    private String accountId;

    @NotBlank(message = "비밀번호는 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,60}",
            message = "비밀번호는 영어, 숫자, 특수기호를 포함한 8~60자리여야 합니다.")
    private String password;

    @NotBlank(message = "이름은 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "^[가-힣]{2,4}$", message = "이름은 한글을 사용하고, 2~4자리여야 합니다.")
    private String name;
}
