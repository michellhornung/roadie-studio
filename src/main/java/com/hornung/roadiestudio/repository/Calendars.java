package com.hornung.roadiestudio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hornung.roadiestudio.model.Calendar;

public interface Calendars extends JpaRepository<Calendar, Integer>{

	public List<Calendar> findByStartDatetimeGreaterThanEqualAndEndDatetimeLessThanEqualOrderByStartDatetime(Date start, Date end);
	
	public Long countIdByStartDatetimeGreaterThanEqualAndEndDatetimeLessThanEqualAndType(Date start, Date end, String type);
	
}