package com.hornung.roadiestudio.report;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

abstract class AbstractReport implements Serializable{

	private static final long serialVersionUID = -8722884982396648283L;
	
	private String initDate;
	private String endDate;

	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private final SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

	protected AbstractReport() {
	}

	protected AbstractReport(String initDate, String endDate) {
		try {
			this.initDate = this.formatter.format(parser.parse(initDate));
			this.endDate = this.formatter.format(parser.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}