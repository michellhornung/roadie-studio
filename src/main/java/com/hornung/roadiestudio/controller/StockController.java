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

import com.hornung.roadiestudio.repository.Stocks;
import com.hornung.roadiestudio.model.Stock;
import com.hornung.roadiestudio.repository.StockType;
import com.hornung.roadiestudio.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private Stocks stocks;
	
	@Autowired 
	private StockType stockType;
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping
	public ModelAndView stockList() {
		ModelAndView mv = new ModelAndView("/stock/StockList");
		List<com.hornung.roadiestudio.model.Stock> allStock = stocks.findAll();
		mv.addObject("allStock", allStock);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newStock(Stock stock) {
		ModelAndView mv = new ModelAndView("/stock/NewStock");
		List<com.hornung.roadiestudio.model.StockType> stockTypes = stockType.findAll();
		mv.addObject("allStockType", stockTypes);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid Stock stock, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newStock(stock);
		}
		stockService.save(stock);
		attributes.addFlashAttribute("message", "Item salvo no estoque com sucesso!");
		return new ModelAndView("redirect:/stock");
		
	}

	@RequestMapping("/delete/{codStock}")
	public String delete(@PathVariable int codStock, RedirectAttributes attributes) {
		stockService.delete(codStock);
		attributes.addFlashAttribute("message", "Item " + "'" + codStock + "'" + " deletado com sucesso!");
		return "redirect:/stock";
	}
	
	@GetMapping("/edit/{codStock}")
	public ModelAndView editar(@PathVariable int codStock) {
		Stock stock = stocks.findOne(codStock);
		ModelAndView mv = newStock(stock);
		mv.addObject(stock);
		return mv;
		
	}
	
}
