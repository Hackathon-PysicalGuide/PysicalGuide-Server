package com.project.mirinae.domain.calendar.service;

import com.project.mirinae.domain.calendar.entity.Calendar;
import com.project.mirinae.domain.calendar.exception.CalendarNotFoundException;
import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarInquiryRequest;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarDataResponse;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarResponse;
import com.project.mirinae.domain.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CalendarInquiryService {

    private static final Logger log = LoggerFactory.getLogger(CalendarInquiryService.class);
    private final CalendarRepository calendarRepository;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public CalendarResponse execute(String date) throws ParseException {

        Date newDate = format.parse(date);

        Calendar found = calendarRepository.findById(newDate).orElseThrow(() -> {
            throw CalendarNotFoundException.EXCEPTION;
        });

        CalendarDataResponse calendarData = CalendarDataResponse.builder()
                .category(found.getCategory())
                .date(found.getDate())
                .isExercise(found.isExercise())
                .build();

        log.info("CalendarInquiry Success!!");

        return CalendarResponse.builder()
                .calendarData(calendarData)
                .build();
    }

}
