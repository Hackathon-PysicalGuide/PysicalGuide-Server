package com.project.mirinae.domain.calendar.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "calendar")
public class Calendar {

    @Id
    private Date date;

    private String category;

    private boolean isExercise;

    @Builder
    public Calendar(Date date, String category, boolean isExercise) {
        this.date = date;
        this.category = category;
        this.isExercise = isExercise;
    }
}
