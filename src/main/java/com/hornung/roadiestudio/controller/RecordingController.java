package com.hornung.roadiestudio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hornung.roadiestudio.model.Band;
import com.hornung.roadiestudio.model.Recording;
import com.hornung.roadiestudio.model.Room;
import com.hornung.roadiestudio.repository.Bands;
import com.hornung.roadiestudio.repository.Recordings;
import com.hornung.roadiestudio.repository.Rooms;
import com.hornung.roadiestudio.repository.Stocks;
import com.hornung.roadiestudio.service.RecordingService;

@Controller
@RequestMapping("/recording")
public class RecordingController {
	
	@Autowired
	private Recordings recordings;
	
	@Autowired 
	private Rooms rooms;
	
	@Autowired
	private Stocks stocks;
	
	@Autowired
	private Bands bands;
	
	@Autowired
	private RecordingService recordingService;
	
	@RequestMapping
	public ModelAndView RecordingList() {
		ModelAndView mv = new ModelAndView("/recording/RecordingList");
		List<Recording> allRecordings = recordings.findAll();
		mv.addObject("allRecordings", allRecordings);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newRecording(Recording recording) {
		ModelAndView mv = new ModelAndView("/recording/NewRecording");
		List<Recording> allRecordings= recordings.findAll();
		mv.addObject("allRecordings", allRecordings);
		List<Room> allRooms = rooms.findAll();
		mv.addObject("allRooms", allRooms);
		//List<Stock> allStocks = stocks.findAll();
		//mv.addObject("allStocks", allStocks);
		List<Band> allBands = bands.findAll();
		mv.addObject("allBands", allBands);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid Recording recording, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newRecording(recording);
		}
		recordingService.save(recording);
		attributes.addFlashAttribute("message", "Gravação salva com sucesso!");
		return new ModelAndView("redirect:/recording");
		
	}

	@RequestMapping("/delete/{codRecording}")
	public String delete(@PathVariable int codRecording, RedirectAttributes attributes) {
		recordingService.delete(codRecording);
		attributes.addFlashAttribute("message", "Gravação deletada com sucesso!");
		return "redirect:/recording";
	}
	
	@GetMapping("/edit/{codRecording}")
	public ModelAndView editar(@PathVariable int codRecording) {
		Recording recording = recordings.findOne(codRecording);
		ModelAndView mv = newRecording(recording);
		mv.addObject(recording);
		return mv;
		
	}
	
}
