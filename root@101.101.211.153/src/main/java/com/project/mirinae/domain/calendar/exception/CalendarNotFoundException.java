package com.project.mirinae.domain.calendar.exception;

import com.project.mirinae.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class CalendarNotFoundException extends BusinessException {

    public static final CalendarNotFoundException EXCEPTION = new CalendarNotFoundException();

    private CalendarNotFoundException() {
        super(HttpStatus.NOT_FOUND, "날짜에 맞는 일정이 없습니다");
    }
}
