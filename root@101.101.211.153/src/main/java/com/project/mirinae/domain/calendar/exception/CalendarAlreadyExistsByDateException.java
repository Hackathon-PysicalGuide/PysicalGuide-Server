package com.project.mirinae.domain.calendar.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class CalendarAlreadyExistsByDateException extends BusinessException {

    public static final CalendarAlreadyExistsByDateException EXCEPTION = new CalendarAlreadyExistsByDateException();

    private CalendarAlreadyExistsByDateException() {
        super(HttpStatus.CONFLICT, "이미 일정이 존재합니다");
    }
}
