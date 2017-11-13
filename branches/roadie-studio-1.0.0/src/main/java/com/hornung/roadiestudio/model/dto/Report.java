package com.hornung.roadiestudio.model.dto;

import java.io.Serializable;

import com.hornung.roadiestudio.report.Type;

public class Report implements Serializable {

	private String initDate;
	private String endDate;

	private Type type;

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	

}