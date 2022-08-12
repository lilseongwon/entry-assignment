package com.example.entryassignment.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyInformationResponse {
    private String accountId;
    private String name;
}
