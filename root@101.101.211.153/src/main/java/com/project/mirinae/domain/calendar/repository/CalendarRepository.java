package com.project.mirinae.domain.calendar.repository;

import com.project.mirinae.domain.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CalendarRepository extends JpaRepository<Calendar, Date> {
}
