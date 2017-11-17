package com.hornung.roadiestudio.service;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Calendar;
import com.hornung.roadiestudio.model.Recording;
import com.hornung.roadiestudio.model.Rental;
import com.hornung.roadiestudio.model.Sale;
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

	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private final SimpleDateFormat formatterDB = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private CalendarService calendarService;
	
	public JasperPrint generate(Report report) {
		if(Type.ANALYTICAL.equals(report.getType())) {
			return this.analytical(report);
		} else {
			return this.synthetical();
		}
	}
	
	private JasperPrint analytical(Report report) {
		Date start;
		Date end;
		try {
			final InputStream jasper = JasperUtil.getJasperFile("analytical_report");
			final InputStream subReportRentalRecording = JasperUtil.getJasperFile("rentals_recording_analytical_report");
			final InputStream subReportStock = JasperUtil.getJasperFile("stock_report");
			final InputStream subReportSales = JasperUtil.getJasperFile("sales_report");
			
			JasperUtil.setParameter("subReportRentalRecording", subReportRentalRecording);
			JasperUtil.setParameter("subReportStock", subReportStock);
			JasperUtil.setParameter("subReportSales", subReportSales);
			
			start = formatterDB.parse(report.getInitDate());
			end = formatterDB.parse(report.getEndDate());
			
			Collection<AnalyticalReport> analyticalReports = new ArrayList<>(0);
			
			Collection<Calendar> calendars = calendarService.findBy(new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()));
			AnalyticalReport analyticalReport = new AnalyticalReport(report.getInitDate(), report.getEndDate());
			
			Collection<RentalRecording> rentalRecordingList = new ArrayList<>(0);
			Collection<Sales> salesList = new ArrayList<>(0);
			Collection<Stock> stockList = new ArrayList<>(0);
			
			for(Calendar calendar : calendars) {
				this.populateRentalRecording(rentalRecordingList, calendar);
				
				int size = calendar.getBand().getSales().size();
				for(Sale sale : calendar.getBand().getSales()) {
					Sales sales = new Sales();
					sales.setName(sale.getName());
					sales.setDescription(sale.getObservation());
					sales.setValue(String.valueOf(sale.getValue()));
					salesList.add(sales);
					
					Stock stock = new Stock();
					stock.setName(sale.getStock().getName());
					stock.setDate(formatter.format(calendar.getStartDatetime()));
					stock.setTotal(String.valueOf(size));
					stockList.add(stock);
				}
			}
			
			analyticalReport.setStockList(stockList);
			analyticalReport.setSalesList(salesList);
			analyticalReport.setRentalRecordingList(rentalRecordingList);
			
			analyticalReports.add(analyticalReport);
			
			JasperUtil.setDataSource(analyticalReports);
			return JasperUtil.fillReport(jasper);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
	}
	
	private JasperPrint synthetical() {
		InputStream jasper = JasperUtil.getJasperFile("synthetical_report");
		
		return JasperUtil.fillReport(jasper);
	}
	
	private Collection<RentalRecording> populateRentalRecording(Collection<RentalRecording> rentalRecordingList, Calendar calendar) {
		for(Rental rental : calendar.getRoom().getRentals()) {
			RentalRecording rentals = new RentalRecording("Locações");
			rentals.setBanda(rental.getBand().getName());
			rentals.setSala(rental.getRoom().getName());
			rentals.setTotal(String.valueOf(calendar.getRoom().getRentals().size()));
			rentals.setData(formatter.format(calendar.getStartDatetime()));
			rentalRecordingList.add(rentals);
		}
		
		for(Recording recording : calendar.getRoom().getRecordings()) {
			RentalRecording record = new RentalRecording("Gravações");
			record.setBanda(recording.getBand().getName());
			record.setSala(recording.getRoom().getName());
			record.setTotal(String.valueOf(calendar.getRoom().getRecordings().size()));
			rentalRecordingList.add(record);
		}
		return rentalRecordingList;
	}
	
	
}