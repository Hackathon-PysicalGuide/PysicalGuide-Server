package com.project.mirinae.domain.calendar.presentation;

import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarDataRequest;
import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarInquiryRequest;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarResponse;
import com.project.mirinae.domain.calendar.service.CalendarInquiryService;
import com.project.mirinae.domain.calendar.service.CalendarModifyService;
import com.project.mirinae.domain.calendar.service.CalendarSaveService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/calendar")
public class CalendarController {

    private static final Logger log = LoggerFactory.getLogger(CalendarController.class);
    private final CalendarSaveService calendarSaveService;
    private final CalendarModifyService calendarModifyService;
    private final CalendarInquiryService calendarInquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public CalendarResponse calendarSave(
            @RequestBody CalendarDataRequest request
    ) throws ParseException {
        return calendarSaveService.execute(request);
    }

    @GetMapping("/")
    public CalendarResponse calendarInquiry(
            @RequestParam("date") String date
    ) throws ParseException {
        return calendarInquiryService.execute(date);
    }

    @PatchMapping("/")
    public CalendarResponse calendarModify(
            @RequestBody CalendarDataRequest request
    ) throws ParseException {
        return calendarModifyService.execute(request);
    }

}
