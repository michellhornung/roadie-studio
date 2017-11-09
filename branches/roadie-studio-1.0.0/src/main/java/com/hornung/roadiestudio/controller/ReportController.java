package com.hornung.roadiestudio.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class ReportController implements Serializable {

	@RequestMapping
	public ModelAndView usersList() {
		ModelAndView mv = new ModelAndView("/report/report");
		return mv;
	}
	
}