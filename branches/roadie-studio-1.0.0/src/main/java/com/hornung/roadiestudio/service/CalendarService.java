package com.hornung.roadiestudio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Calendar;
import com.hornung.roadiestudio.repository.Calendars;

@Service
public class CalendarService {
	
	@Autowired
	private Calendars calendars;
	
	public void save(Calendar calendar){
		//TODO regras de negócio
		this.calendars.save(calendar);
	}
	
	public void delete(int codCalendar) {
		this.calendars.delete(codCalendar);
	}
	
	public List<Calendar> findBy(Date initDate, Date endDate) {
		return calendars.findByStartDatetimeGreaterThanEqualAndEndDatetimeLessThanEqual(initDate, endDate);
	}
	
	public Long countBy(Date initDate, Date endDate, String type) {
		return calendars.countIdByStartDatetimeGreaterThanEqualAndEndDatetimeLessThanEqualAndType(initDate, endDate, type);
	}

}