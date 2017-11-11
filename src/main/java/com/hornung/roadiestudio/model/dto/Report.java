package com.hornung.roadiestudio.model.dto;

import java.io.Serializable;

public class Report implements Serializable {

	private String initDate;
	private String endDate;

	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}