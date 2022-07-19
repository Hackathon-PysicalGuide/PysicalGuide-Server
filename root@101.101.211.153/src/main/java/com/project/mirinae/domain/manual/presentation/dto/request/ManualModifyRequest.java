package com.project.mirinae.domain.manual.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class ManualModifyRequest {

    private String title;

    private String content;

    private String category;

}
