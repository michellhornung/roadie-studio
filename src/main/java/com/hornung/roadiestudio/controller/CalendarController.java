package com.hornung.roadiestudio.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornung.roadiestudio.model.Band;
import com.hornung.roadiestudio.model.Recording;
import com.hornung.roadiestudio.model.Rental;
import com.hornung.roadiestudio.model.Room;
import com.hornung.roadiestudio.model.dto.Events;
import com.hornung.roadiestudio.repository.Bands;
import com.hornung.roadiestudio.repository.Calendars;
import com.hornung.roadiestudio.repository.Rooms;

import antlr.debug.Event;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private Calendars calendars;
	
	@Autowired 
	private Rooms rooms;
	
	@Autowired
	private Bands bands;
	

	@RequestMapping
	public ModelAndView calendarList() {
		ModelAndView mv = new ModelAndView("/calendar/CalendarList");
		List<com.hornung.roadiestudio.model.Calendar> allCalendars = calendars.findAll();
		mv.addObject("allCalendars", allCalendars);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	private String listaOpcoes(@RequestBody Events events) {
		
		com.hornung.roadiestudio.model.Calendar calendar = calendars.findOne(events.getId());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        		
		if(calendar != null) {
			
			calendar.setDescription(events.getTitle());
			calendar.setType(events.getType().equalsIgnoreCase("Locação") ? "L" : "G");
			
			try {
				
				calendar.setEndDatetime((java.util.Date)formatter.parse(events.getEnd()));
				calendar.setStartDatetime((java.util.Date)formatter.parse(events.getStart()));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		calendars.save(calendar);
		
		return "redirect:/calendar";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody Events events, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("/calendar/CalendarList");
		
		com.hornung.roadiestudio.model.Calendar calendar = calendars.findOne(events.getId());
		calendars.delete(calendar.getCodCalendar());
		attributes.addFlashAttribute("message", "Agendamento deletado com sucesso!");
				
		return "redirect:/calendar";
	}
	
	@RequestMapping(value = "/getEventos.json", method = RequestMethod.GET)	
	public @ResponseBody List<Events> GetEventos() throws ParseException{
		
		List<com.hornung.roadiestudio.model.Calendar> calendarList = calendars.findAll();
		List<Events> eventsList = new ArrayList<Events>(0);
		
		String mesAtual = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+ 1);
		
		if(mesAtual.length() <2)
			mesAtual = "0" + mesAtual;
		
		DateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		
		for(com.hornung.roadiestudio.model.Calendar c :calendarList) {
			
			Events events = new Events();
			
			//id
			events.setId(c.getCodCalendar());
			
			//titulo
			events.setTitle(c.getDescription());
			
			//tipo
			events.setType(c.getType());
			
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
		
		List<String> types = new ArrayList<String>(0);
		types.add("Gravação");
		types.add("Locação");
		mv.addObject("allTypes", types);
		
		List<Room> allRooms =  rooms.findAll();
		mv.addObject("allRooms", allRooms);
		
		List<Band> allBands = bands.findAll();
		mv.addObject("allBands", allBands);
		
				
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid com.hornung.roadiestudio.model.Calendar calendar, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newCalendar(calendar);
		}
		
		calendar.setType(calendar.getType().equalsIgnoreCase("Locação") ? "L" : "G");
		
		if (calendar.getStartDatetime().equals(calendar.getEndDatetime())) {
			attributes.addFlashAttribute("error", "Horário inicio não pode ser igual a Horário final!");
			return new ModelAndView("redirect:/calendar");
		}
		
		calendars.save(calendar);
		attributes.addFlashAttribute("message", "Agendamento salvo com sucesso!");
		return new ModelAndView("redirect:/calendar");
		
	}

}
