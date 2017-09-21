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
import com.hornung.roadiestudio.model.BandGenre;
import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.BandGenres;
import com.hornung.roadiestudio.repository.Bands;
import com.hornung.roadiestudio.repository.Users;
import com.hornung.roadiestudio.service.BandService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private Bands bands;
	
	@Autowired 
	private BandGenres bandGenres;
	
	@Autowired
	private Users users;
	
	@Autowired
	private BandService bandService;
	
	@RequestMapping
	public ModelAndView bandList() {
		ModelAndView mv = new ModelAndView("/band/BandList");
		List<Band> allBands = bands.findAll();
		mv.addObject("allBands", allBands);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newBand(Band band) {
		ModelAndView mv = new ModelAndView("/band/NewBand");
		List<BandGenre> allGenres =  bandGenres.findAll();
		mv.addObject("allGenres", allGenres);
		List<User> allUsers = users.findAll();
		mv.addObject("allUsers", allUsers);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid Band band, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newBand(band);
		}
		bandService.save(band);
		attributes.addFlashAttribute("message", "Banda salva com sucesso!");
		return new ModelAndView("redirect:/band");
		
	}

	@RequestMapping("/delete/{codBand}")
	public String delete(@PathVariable int codBand, RedirectAttributes attributes) {
		bandService.delete(codBand);
		attributes.addFlashAttribute("message", "Banda deletada com sucesso!");
		return "redirect:/band";
	}
	
	@GetMapping("/edit/{codBand}")
	public ModelAndView editar(@PathVariable int codBand) {
		Band band = bands.findOne(codBand);
		ModelAndView mv = newBand(band);
		mv.addObject(band);
		return mv;
		
	}
}
