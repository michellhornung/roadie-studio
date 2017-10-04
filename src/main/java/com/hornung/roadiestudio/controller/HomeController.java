package com.hornung.roadiestudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hornung.roadiestudio.model.Room;
import com.hornung.roadiestudio.repository.Rooms;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private Rooms rooms;
	
	@RequestMapping
	public ModelAndView roomsList() {
		ModelAndView mv = new ModelAndView("/home/HomeList");
		List<Room> allRooms = rooms.findAll();
		mv.addObject("allRooms", allRooms);
		return mv;
	}
	
	
	
	
}
