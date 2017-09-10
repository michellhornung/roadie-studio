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

import com.hornung.roadiestudio.model.BandGenre;
import com.hornung.roadiestudio.repository.BandGenres;
import com.hornung.roadiestudio.service.BandGenreService;

@Controller
@RequestMapping("/bandGenre")
public class BandGenreController {
	
	@Autowired
	private BandGenres bandGenres;
	
	@Autowired
	private BandGenreService bandGenreService;
	
	/**
	 * List all band genres
	 * @return band genres
	 */
	@RequestMapping
	public ModelAndView bandGenreList() {
		ModelAndView mv = new ModelAndView("/bandGenre/BandGenreList");
		List<BandGenre> allBandGenres = bandGenres.findAll();
		mv.addObject("allBandGenres", allBandGenres);
		return mv;
	}
	
	// Load the page to prepare to create a new band genre
	@RequestMapping("/new")
	public ModelAndView newBandGenre(BandGenre bandGenre) {
		ModelAndView mv = new ModelAndView("/bandGenre/NewBandGenre");
		mv.addObject("allBandGenres", bandGenres);
		return mv;
	}
	
	// Create a new band genre, persisting it on data base
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid BandGenre bandGenre, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newBandGenre(bandGenre);
		}
		bandGenreService.save(bandGenre);
		attributes.addFlashAttribute("message", "Gênero de banda salvo com sucesso!");
		return new ModelAndView("redirect:/bandGenre/new");
		
	}

	@RequestMapping("/delete/{codBandGenre}")
	public String delete(@PathVariable int codBandGenre, RedirectAttributes attributes) {
		bandGenreService.delete(codBandGenre);
		attributes.addFlashAttribute("message", "Gênero de banda deletado com sucesso!");
		return "redirect:/bandGenre";
	}
	
	@GetMapping("/edit/{codBandGenre}")
	public ModelAndView editar(@PathVariable int codBandGenre) {
		BandGenre bandGenre = bandGenres.findOne(codBandGenre);
		ModelAndView mv = newBandGenre(bandGenre);
		mv.addObject(bandGenre);
		return mv;
		
	}
	
}
