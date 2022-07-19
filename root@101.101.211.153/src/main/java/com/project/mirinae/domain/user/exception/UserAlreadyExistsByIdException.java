package com.project.mirinae.domain.user.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsByIdException extends BusinessException {

    public static final UserAlreadyExistsByIdException EXCEPTION = new UserAlreadyExistsByIdException();

    private UserAlreadyExistsByIdException() {
        super(HttpStatus.CONFLICT, "응 아이디 이미 있어");
    }

}
