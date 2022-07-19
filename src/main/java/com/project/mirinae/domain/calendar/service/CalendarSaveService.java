package com.project.mirinae.domain.calendar.service;

import com.project.mirinae.domain.calendar.entity.Calendar;
import com.project.mirinae.domain.calendar.exception.CalendarAlreadyExistsByDateException;
import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarDataRequest;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarDataResponse;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarResponse;
import com.project.mirinae.domain.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CalendarSaveService {

    private static final Logger log = LoggerFactory.getLogger(CalendarSaveService.class);
    private final CalendarRepository calendarRepository;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional
    public CalendarResponse execute(CalendarDataRequest request) throws ParseException {

        Date date = format.parse(request.getDate());

        calendarRepository.findById(date).ifPresent(m -> {
            throw CalendarAlreadyExistsByDateException.EXCEPTION;
        });

        Calendar calendar = Calendar.builder()
                .category(request.getCategory())
                .date(date)
                .isExercise(request.isExercise())
                .build();

        calendar = calendarRepository.save(calendar);

        CalendarDataResponse calendarData = CalendarDataResponse.builder()
                .category(calendar.getCategory())
                .date(calendar.getDate())
                .isExercise(calendar.isExercise())
                .build();

        log.info("CalendarSave Success!!");

        return CalendarResponse.builder()
                .calendarData(calendarData)
                .build();
    }

}
