package com.hornung.roadiestudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hornung.roadiestudio.model.Band;
import com.hornung.roadiestudio.repository.Bands;

@Controller
@RequestMapping("/band")
public class BandController {

	@Autowired
	private Bands bands;
	
	/*@Autowired 
	private BandGenres bandGenres;
	
	@Autowired
	private Users users;*/
	
	@RequestMapping
	public ModelAndView bandList() {
		ModelAndView mv = new ModelAndView("/band/BandList");
		List<Band> allBands = bands.findAll();
		mv.addObject("allBands", allBands);
		return mv;
	}
}
