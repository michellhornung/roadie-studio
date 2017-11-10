package com.hornung.roadiestudio.report;

import java.io.Serializable;

import com.hornung.roadiestudio.util.Field;
import com.hornung.roadiestudio.util.JrXml;

@JrXml(name = "sales_report")
public class Sales implements Serializable {

	private static final long serialVersionUID = 3813133757286297738L;
	
	@Field
	private String name;
	
	@Field
	private String description;
	
	@Field
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
