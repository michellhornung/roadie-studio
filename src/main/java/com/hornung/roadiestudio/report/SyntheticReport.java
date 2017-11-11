package com.hornung.roadiestudio.report;

import java.io.Serializable;

public class SyntheticReport implements Serializable {

	private static final long serialVersionUID = -6816779404831328261L;
	
	private String initDate;
	private String endDate;
	
	private Long totalRentals;
	private Long totalRecording;
	private Long totalStock;
	private Long totalSales;
	
	public SyntheticReport() {
	}

	public SyntheticReport(String initDate, String endDate) {
		this.initDate = initDate;
		this.endDate = endDate;
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

	public Long getTotalRentals() {
		return totalRentals;
	}

	public void setTotalRentals(Long totalRentals) {
		this.totalRentals = totalRentals;
	}

	public Long getTotalRecording() {
		return totalRecording;
	}

	public void setTotalRecording(Long totalRecording) {
		this.totalRecording = totalRecording;
	}

	public Long getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Long totalStock) {
		this.totalStock = totalStock;
	}

	public Long getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(Long totalSales) {
		this.totalSales = totalSales;
	}
	
}
