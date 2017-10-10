package com.hornung.roadiestudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hornung.roadiestudio.model.Calendar;

public interface Calendars extends JpaRepository<Calendar, Integer>{

}
