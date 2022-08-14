package com.example.entryassignment.domain.book.presentation.dto.request;

import com.example.entryassignment.domain.book.domain.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class AdminAddBookRequest {

    @Size(min = 1, max = 60, message = "책 제목은 Null을 허용하지 않으며, 1~60자 내외여야 합니다.")
    private String title;

    private String picture;

    @Size(min = 1, max = 20, message = "저자는 Null을 허용하지 않으며, 1~20자 내외여야 합니다.")
    private String author;

    @NotBlank
    @Size(min = 10, max = 20, message = "ISBN은 Null과 공백을 허용하지 않으며, 10~20자 이하여야 합니다.")
    private Integer isbn;

    @Size(min = 1, max = 60, message = "출판사는 Null을 허용하지 않으며, 1~60자 내외여야 합니다.")
    private String publisher;

    @Size(min = 1, max = 60, message = "장르는 Null을 허용하지 않으며, enum클래스에 있는 옵션을 이용한 1~10자 내외여야 합니다.")
    private Genre genre;
}
