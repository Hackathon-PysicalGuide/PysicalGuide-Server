package com.project.mirinae.domain.calendar.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter @AllArgsConstructor
@Builder
public class CalendarDataResponse {

    private final String category;

    private final Date date;

    private final boolean isExercise;

}
