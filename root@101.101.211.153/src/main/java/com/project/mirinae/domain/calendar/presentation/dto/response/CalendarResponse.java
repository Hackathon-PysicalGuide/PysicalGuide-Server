package com.project.mirinae.domain.calendar.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class CalendarResponse {

    private final CalendarDataResponse calendarData;

}
