package com.hornung.roadiestudio.report;

import java.io.Serializable;
import java.util.Collection;

import com.hornung.roadiestudio.util.Field;
import com.hornung.roadiestudio.util.ForJasperReport;
import com.hornung.roadiestudio.util.SubReport;

@ForJasperReport(jrxml = "analytical_report")
public class AnalyticalReport implements Serializable {

	private static final long serialVersionUID = -5752528235383622280L;

	@Field
	private String initDate;

	@Field
	private String endDate;

	@Field
	@SubReport(parameterName = "subReportRentalRecording")
	private Collection<RentalRecording> rentalRecordingList;

	@Field
	@SubReport(parameterName = "subReportStockSales")
	private Collection<StockSales> stockSalesList;

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

	public Collection<RentalRecording> getRentalRecordingList() {
		return rentalRecordingList;
	}

	public void setRentalRecordingList(Collection<RentalRecording> rentalRecordingList) {
		this.rentalRecordingList = rentalRecordingList;
	}

	public Collection<StockSales> getStockSalesList() {
		return stockSalesList;
	}

	public void setStockSalesList(Collection<StockSales> stockSalesList) {
		this.stockSalesList = stockSalesList;
	}
}