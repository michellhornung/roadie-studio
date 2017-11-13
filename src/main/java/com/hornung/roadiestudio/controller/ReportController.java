package com.hornung.roadiestudio.controller;

import java.io.Serializable;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hornung.roadiestudio.model.dto.Report;

@Controller
@RequestMapping("/report")
public class ReportController implements Serializable {

	@RequestMapping
	public ModelAndView report(Report report, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/report/report");
		
		if(Objects.isNull(report)) {
			
			
			
			return mv;
		}
		
		
		
		return mv;
	}
	
}