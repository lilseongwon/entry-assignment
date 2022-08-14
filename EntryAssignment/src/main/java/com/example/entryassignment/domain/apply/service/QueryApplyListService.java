package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.domain.ApplyList;
import com.example.entryassignment.domain.apply.domain.repository.ApplyListReposiroty;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryApplyInfoListResponse;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryApplyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryApplyListService {

    private final ApplyListReposiroty applyListReposiroty;

    @Transactional(readOnly = true)
    public QueryApplyInfoListResponse execute() {
        List<QueryApplyInfoResponse> applyList = applyListReposiroty.findAllByOrderById()
                .stream()
                .map(this::applyBuilder)
                .collect(Collectors.toList());

        return new QueryApplyInfoListResponse(applyList);
    }

    private QueryApplyInfoResponse applyBuilder(ApplyList applyList) {
        return QueryApplyInfoResponse.builder()
                .title(applyList.getTitle())
                .isbn(applyList.getIsbn())
                .build();
    }
}