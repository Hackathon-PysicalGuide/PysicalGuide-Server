package com.project.mirinae.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter @AllArgsConstructor
@Builder
public class UserSignInRequest {

    @NonNull
    private String id;

    @NonNull
    private String pw;

}
