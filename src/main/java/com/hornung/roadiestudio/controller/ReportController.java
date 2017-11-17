package com.hornung.roadiestudio.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hornung.roadiestudio.model.dto.Report;
import com.hornung.roadiestudio.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/report")
public class ReportController implements Serializable {
	
	private static final long serialVersionUID = -7783550961128058632L;
	
	@Autowired
	private ReportService service;

	@RequestMapping
	public ModelAndView report(Report report, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/report/report");
		
		if(Objects.nonNull(report.getInitDate()) && Objects.nonNull(report.getEndDate())) {
			
			JasperPrint print = service.generate(report);
			
			print(print, response);
			
			return mv;
		}
		
		return mv;
	}
	
	private void print(JasperPrint print, HttpServletResponse response) {
		try {
			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=relatorio_analitico.pdf");
			
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, stream);
			
			stream.flush();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
}