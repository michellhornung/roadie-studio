package com.hornung.roadiestudio.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.dto.Report;
import com.hornung.roadiestudio.report.AnalyticalReport;
import com.hornung.roadiestudio.report.RentalRecording;
import com.hornung.roadiestudio.report.Sales;
import com.hornung.roadiestudio.report.Stock;
import com.hornung.roadiestudio.report.Type;
import com.hornung.roadiestudio.util.report.JasperUtil;

import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportService {

	private RentalService rentalService;
	
	private RecordingService  recordingService;
	
	private StockService stockService;
	
	
	public JasperPrint generate(Report report) {
		if(Type.ANALYTICAL.equals(report.getType())) {
			return this.analytical();
		} else {
			return this.synthetical();
		}
	}
	
	private JasperPrint analytical() {
		InputStream jasper = JasperUtil.getJasperFile("analytical_report");
		InputStream subReportRentalRecording = JasperUtil.getJasperFile("rentals_recording_analytical_report");
		InputStream subReportStock = JasperUtil.getJasperFile("stock_report");
		InputStream subReportSales = JasperUtil.getJasperFile("sales_report");
		
		JasperUtil.setParameter("subReportRentalRecording", subReportRentalRecording);
		JasperUtil.setParameter("subReportStock", subReportStock);
		JasperUtil.setParameter("subReportSales", subReportSales);
		
		Collection<AnalyticalReport> analyticalReports = new ArrayList<>(0);
		Collection<RentalRecording> rentalRecordings = new ArrayList<>(0);
		Collection<Stock> stocks = new ArrayList<>(0);
		Collection<Sales> sales = new ArrayList<>(0);
	
		
		JasperUtil.setDataSource(analyticalReports);
		return JasperUtil.fillReport(jasper);
	}
	
	private JasperPrint synthetical() {
		InputStream jasper = JasperUtil.getJasperFile("synthetical_report");
		
		return JasperUtil.fillReport(jasper);
	}
	
	
}