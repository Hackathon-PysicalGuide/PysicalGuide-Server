package com.project.mirinae.domain.manual.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class ManualAddRequest {

    private String title;

    private String content;

    private String category;

}
