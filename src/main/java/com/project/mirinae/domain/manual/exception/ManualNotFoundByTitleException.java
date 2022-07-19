package com.project.mirinae.domain.manual.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ManualNotFoundByTitleException extends BusinessException {

    public static final ManualNotFoundByTitleException EXCEPTION = new ManualNotFoundByTitleException();

    private ManualNotFoundByTitleException() {
        super(HttpStatus.NOT_FOUND, "제목을 찾지 못하였습니다");
    }
}
