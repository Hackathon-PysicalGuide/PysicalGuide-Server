package com.project.mirinae.domain.manual.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
@Builder
public class ManualListReponse {

    private List<ManualResponse> list;

}
