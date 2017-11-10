package com.hornung.roadiestudio.report;

import java.io.Serializable;

import com.hornung.roadiestudio.util.Field;
import com.hornung.roadiestudio.util.JrXml;

@JrXml(name = "stock_report")
public class Stock implements Serializable {

	private static final long serialVersionUID = -1772721458938793526L;

	@Field
	private String name;

	@Field
	private String date;

	@Field
	private String total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Stock() {
	}

}