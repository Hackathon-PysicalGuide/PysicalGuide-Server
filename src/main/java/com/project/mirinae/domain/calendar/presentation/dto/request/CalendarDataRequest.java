package com.project.mirinae.domain.calendar.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter @AllArgsConstructor
@Builder
public class CalendarDataRequest {

    private final String category;

    private final String date;

    private final boolean isExercise;

}
