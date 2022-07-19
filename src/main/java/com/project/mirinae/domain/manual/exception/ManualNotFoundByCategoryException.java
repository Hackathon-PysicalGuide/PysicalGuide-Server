package com.project.mirinae.domain.manual.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ManualNotFoundByCategoryException extends BusinessException {

    public static final ManualNotFoundByCategoryException EXCEPTION = new ManualNotFoundByCategoryException();

    private ManualNotFoundByCategoryException() {
        super(HttpStatus.NOT_FOUND, "없는 카테고리입니다");
    }
}
