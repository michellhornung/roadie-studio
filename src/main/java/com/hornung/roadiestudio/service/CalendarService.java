package com.hornung.roadiestudio.service;

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

}
