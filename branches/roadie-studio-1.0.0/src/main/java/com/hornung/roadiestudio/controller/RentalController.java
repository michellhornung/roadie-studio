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
import com.hornung.roadiestudio.model.Rental;
import com.hornung.roadiestudio.model.Room;
import com.hornung.roadiestudio.model.Stock;
import com.hornung.roadiestudio.repository.Bands;
import com.hornung.roadiestudio.repository.Rentals;
import com.hornung.roadiestudio.repository.Rooms;
import com.hornung.roadiestudio.repository.Stocks;
import com.hornung.roadiestudio.service.RentalService;

@Controller
@RequestMapping("/rental")
public class RentalController {
	
	@Autowired
	private Rentals rentals;
	
	@Autowired 
	private Rooms rooms;
	
	@Autowired
	private Stocks stocks;
	
	@Autowired
	private Bands bands;
	
	@Autowired
	private RentalService rentalService;
	
	@RequestMapping
	public ModelAndView RentalList() {
		ModelAndView mv = new ModelAndView("/rental/RentalList");
		List<Rental> allRentals = rentals.findAll();
		mv.addObject("allRentals", allRentals);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newRental(Rental rental) {
		ModelAndView mv = new ModelAndView("/rental/NewRental");
		List<Rental> allRentals = rentals.findAll();
		mv.addObject("allRentals", allRentals);
		
		
		
		List<Room> allRooms = rooms.findAll();
		mv.addObject("allRooms", allRooms);
		//List<Stock> allStocks = stocks.findAll();
		//mv.addObject("allStocks", allStocks);
		List<Band> allBands = bands.findAll();
		mv.addObject("allBands", allBands);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid Rental rental, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newRental(rental);
		}
		if (rental.getStartDatetime().equals(rental.getEndDatetime())) {
			attributes.addFlashAttribute("error", "Horário inicio não pode ser igual a Horário final!");
			return new ModelAndView("redirect:/rental");
		}
		rentalService.save(rental);
		attributes.addFlashAttribute("message", "Locação salva com sucesso!");
		return new ModelAndView("redirect:/rental");
		
	}

	@RequestMapping("/delete/{codRental}")
	public String delete(@PathVariable int codRental, RedirectAttributes attributes) {
		rentalService.delete(codRental);
		attributes.addFlashAttribute("message", "Locação deletada com sucesso!");
		return "redirect:/rental";
	}
	
	@GetMapping("/edit/{codRental}")
	public ModelAndView editar(@PathVariable int codRental) {
		Rental rental = rentals.findOne(codRental);
		ModelAndView mv = newRental(rental);
		mv.addObject(rental);
		return mv;
		
	}
	
}
