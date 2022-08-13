package com.example.entryassignment.domain.book.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryApplyInfoResponse {
    private final String title;
    private final String isbn;

}
