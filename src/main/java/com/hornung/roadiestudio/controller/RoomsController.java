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

import com.hornung.roadiestudio.model.Room;
import com.hornung.roadiestudio.repository.Rooms;
import com.hornung.roadiestudio.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomsController {
	
	@Autowired
	private Rooms rooms;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping
	public ModelAndView roomsList() {
		ModelAndView mv = new ModelAndView("/room/RoomsList");
		List<Room> allRooms = rooms.findAll();
		mv.addObject("allRooms", allRooms);
		return mv;
	}
	
	// Load the page to prepare to create a new band genre
	@RequestMapping("/new")
	public ModelAndView newRoom(Room room) {
		ModelAndView mv = new ModelAndView("/room/NewRoom");
		mv.addObject("allRooms", rooms);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid Room room, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newRoom(room);
		}
		roomService.save(room);
		attributes.addFlashAttribute("message", "Sala salva com sucesso!");
		return new ModelAndView("redirect:/room");
		
	}

	@RequestMapping("/delete/{codRoom}")
	public String delete(@PathVariable int codRoom, RedirectAttributes attributes) {
		roomService.delete(codRoom);
		attributes.addFlashAttribute("message", "Sala deletada com sucesso!");
		return "redirect:/room";
	}
	
	@GetMapping("/edit/{codRoom}")
	public ModelAndView editar(@PathVariable int codRoom) {
		Room room = rooms.findOne(codRoom);
		ModelAndView mv = newRoom(room);
		mv.addObject(room);
		return mv;
		
	}
	
}
