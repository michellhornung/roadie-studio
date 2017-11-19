package com.hornung.roadiestudio.report;

import java.util.Collection;

import com.hornung.roadiestudio.util.report.Field;
import com.hornung.roadiestudio.util.report.JrXml;
import com.hornung.roadiestudio.util.report.SubReport;

@JrXml(name = "analytical_report")
public class AnalyticalReport extends AbstractReport {

	private static final long serialVersionUID = 6734466351170744648L;

	@Field
	@SubReport(parameterName = "subReportRentalRecording")
	private Collection<RentalRecording> rentalRecordingList;

	@Field
	@SubReport(parameterName = "subReportStock")
	private Collection<Stock> stockList;

	@Field
	@SubReport(parameterName = "subReportSales")
	private Collection<Sales> salesList;

	public AnalyticalReport(String initDate, String endDate) {
		super(initDate, endDate);
	}
	
	public Collection<RentalRecording> getRentalRecordingList() {
		return rentalRecordingList;
	}

	public void setRentalRecordingList(Collection<RentalRecording> rentalRecordingList) {
		this.rentalRecordingList = rentalRecordingList;
	}

	public Collection<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(Collection<Stock> stockList) {
		this.stockList = stockList;
	}

	public Collection<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(Collection<Sales> sales) {
		this.salesList = sales;
	}

}