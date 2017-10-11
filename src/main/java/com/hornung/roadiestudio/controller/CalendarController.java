package com.hornung.roadiestudio.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornung.roadiestudio.model.Recording;
import com.hornung.roadiestudio.model.Rental;
import com.hornung.roadiestudio.model.dto.Events;
import com.hornung.roadiestudio.repository.Calendars;
import com.hornung.roadiestudio.repository.Recordings;
import com.hornung.roadiestudio.repository.Rentals;

import antlr.debug.Event;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private Calendars calendars;
	
	@Autowired 
	private Rentals rentals;
	
	@Autowired
	private Recordings recordings;
	

	@RequestMapping
	public ModelAndView calendarList() {
		ModelAndView mv = new ModelAndView("/calendar/CalendarList");
		List<com.hornung.roadiestudio.model.Calendar> allCalendars = calendars.findAll();
		mv.addObject("allCalendars", allCalendars);
		return mv;
	}
	

	@RequestMapping(value = "/getEventos.json", method = RequestMethod.GET)	
	public @ResponseBody List<Events> GetEventos() throws ParseException{
		
		List<com.hornung.roadiestudio.model.Calendar> calendarList = calendars.findAll();
		List<Events> eventsList = new ArrayList<Events>(0);
		
		String mesAtual = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+ 1);
		
		if(mesAtual.length() <2)
			mesAtual = "0" + mesAtual;
						
		DateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		
		for(com.hornung.roadiestudio.model.Calendar c :calendarList) {
			
			Events events = new Events();
			
			//titulo
			events.setTitle(c.getDescription());
			
			//Hora inicial
			events.setStart(df.format(c.getStartDatetime()));
			events.getStart().replace(" ", "T");

			//Hora final
			events.setEnd(df.format(c.getEndDatetime()));
			events.getEnd().replace(" ", "T");
			 
			eventsList.add(events);
		}
						
		return eventsList;
		
	}
	
	@RequestMapping("/new")
	public ModelAndView newCalendar(com.hornung.roadiestudio.model.Calendar calendar) {
		ModelAndView mv = new ModelAndView("/calendar/NewCalendar");
		List<Rental> allRentals =  rentals.findAll();
		mv.addObject("allRentals", allRentals);
		
		List<Recording> allRecordings = recordings.findAll();
		mv.addObject("allRecordings", allRecordings);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid com.hornung.roadiestudio.model.Calendar calendar, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newCalendar(calendar);
		}
		
		if (calendar.getStartDatetime().equals(calendar.getEndDatetime())) {
			attributes.addFlashAttribute("error", "Horário inicio não pode ser igual a Horário final!");
			return new ModelAndView("redirect:/calendar");
		}
		
		calendars.save(calendar);
		attributes.addFlashAttribute("message", "Agendamento salvo com sucesso!");
		return new ModelAndView("redirect:/calendar");
		
	}

	@RequestMapping("/delete/{codCalendar}")
	public String delete(@PathVariable int codCalendar, RedirectAttributes attributes) {
		calendars.delete(codCalendar);
		attributes.addFlashAttribute("message", "Agendamento deletado com sucesso!");
		return "redirect:/calendar";
	}
	
	@GetMapping("/edit/{codCalendar}")
	public ModelAndView editar(@PathVariable int codBand) {
		com.hornung.roadiestudio.model.Calendar calendar = calendars.findOne(codBand);
		ModelAndView mv = newCalendar(calendar);
		mv.addObject(calendar);
		return mv;
	}
}
