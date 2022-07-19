package com.project.mirinae.domain.manual.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class ManualResponse {

    private final int idx;

    private final String title;

    private final String content;

    private final String category;

}
