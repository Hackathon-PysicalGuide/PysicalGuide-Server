package com.project.mirinae.domain.calendar.presentation;

import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarDataRequest;
import com.project.mirinae.domain.calendar.presentation.dto.request.CalendarInquiryRequest;
import com.project.mirinae.domain.calendar.presentation.dto.response.CalendarResponse;
import com.project.mirinae.domain.calendar.service.CalendarInquiryService;
import com.project.mirinae.domain.calendar.service.CalendarModifyService;
import com.project.mirinae.domain.calendar.service.CalendarSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/calendar")
public class CalendarController {

    private final CalendarSaveService calendarSaveService;
    private final CalendarModifyService calendarModifyService;
    private final CalendarInquiryService calendarInquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public CalendarResponse calendarSave(
            @RequestBody CalendarDataRequest request
    ) {
        return calendarSaveService.execute(request);
    }

    @GetMapping("/")
    public CalendarResponse calendarInquiry(
            @RequestBody CalendarInquiryRequest request
    ) {
        return calendarInquiryService.execute(request);
    }

    @PatchMapping("/")
    public CalendarResponse calendarModify(
            @RequestBody CalendarDataRequest request
    ) {
        return calendarModifyService.execute(request);
    }

}
