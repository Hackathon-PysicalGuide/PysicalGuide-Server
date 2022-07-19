package com.project.mirinae.domain.calendar.service;

import com.project.mirinae.domain.calendar.entity.Calendar;
import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarDataRequest;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarDataResponse;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarResponse;
import com.project.mirinae.domain.calendar.repository.CalendarRepository;
import com.project.mirinae.global.utils.ModifyUtil;
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
public class CalendarModifyService {

    private static final Logger log = LoggerFactory.getLogger(CalendarModifyService.class);
    private final CalendarRepository calendarRepository;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional
    public CalendarResponse execute(CalendarDataRequest request) throws ParseException {

        Date date = format.parse(request.getDate());

        ModifyUtil<String> modify = new ModifyUtil<>();

        Calendar calendar = calendarRepository.getReferenceById(date);

        calendar = Calendar.builder()
                .category(modify.getUpdated(calendar.getCategory(), request.getCategory()))
                .date(calendar.getDate())
                .isExercise(request.isExercise())
                .build();

        calendarRepository.save(calendar);

        CalendarDataResponse calendarData = CalendarDataResponse.builder()
                .category(calendar.getCategory())
                .date(calendar.getDate())
                .isExercise(calendar.isExercise())
                .build();

        log.info("CalendarModify Success!!");

        return CalendarResponse.builder()
                .calendarData(calendarData)
                .build();
    }

}
