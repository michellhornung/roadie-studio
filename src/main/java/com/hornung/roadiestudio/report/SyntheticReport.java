package com.hornung.roadiestudio.report;

import com.hornung.roadiestudio.util.report.JrXml;

@JrXml(name = "synthetic_report")
public class SyntheticReport extends AbstractReport {

	private static final long serialVersionUID = 1228935048421731926L;
	
	private Long totalRentals;
	private Long totalRecording;
	private Long totalStock;
	private Long totalSales;
	
	public SyntheticReport() {
	}

	public SyntheticReport(String initDate, String endDate) {
		super(initDate, endDate);
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
