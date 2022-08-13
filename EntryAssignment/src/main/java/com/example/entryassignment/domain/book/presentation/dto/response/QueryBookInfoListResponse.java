package com.example.entryassignment.domain.book.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class QueryBookInfoListResponse {
    private final List<QueryBookInfoResponse> bookLists;
}
