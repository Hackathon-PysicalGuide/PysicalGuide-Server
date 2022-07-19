package com.project.mirinae.domain.manual.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class ManualAlreadyExistsByTitleException extends BusinessException {

    public static final ManualAlreadyExistsByTitleException EXCEPTION = new ManualAlreadyExistsByTitleException();

    private ManualAlreadyExistsByTitleException() {
        super(HttpStatus.CONFLICT, "이미 제목이 존재합니다");
    }
}
