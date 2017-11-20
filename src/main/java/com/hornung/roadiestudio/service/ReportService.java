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
import com.hornung.roadiestudio.report.AnalyticalReport;
import com.hornung.roadiestudio.report.RentalRecording;
import com.hornung.roadiestudio.report.Report;
import com.hornung.roadiestudio.report.Sales;
import com.hornung.roadiestudio.report.Stock;
import com.hornung.roadiestudio.report.SyntheticReport;
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
			return this.synthetical(report);
		}
	}
	
	private JasperPrint analytical(Report report) {
		try {
			final InputStream jasper = JasperUtil.getJasperFile("analytical_report");
			final InputStream subReportRentalRecording = JasperUtil.getJasperFile("rentals_recording_analytical_report");
			final InputStream subReportStock = JasperUtil.getJasperFile("stock_report");
			final InputStream subReportSales = JasperUtil.getJasperFile("sales_report");
			
			JasperUtil.setParameter("subReportRentalRecording", subReportRentalRecording);
			JasperUtil.setParameter("subReportStock", subReportStock);
			JasperUtil.setParameter("subReportSales", subReportSales);
			
			Date start = formatterDB.parse(report.getInitDate());
			Date end = formatterDB.parse(report.getEndDate());
			
			Collection<AnalyticalReport> analyticalReports = new ArrayList<>(0);
			
			Collection<Calendar> calendars = calendarService.findBy(new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()));
			AnalyticalReport analyticalReport = new AnalyticalReport(report.getInitDate(), report.getEndDate());
			
			Collection<RentalRecording> rentalRecordingList = new ArrayList<>(0);
			Collection<Sales> salesList = new ArrayList<>(0);
			Collection<Stock> stockList = new ArrayList<>(0);
			
			calendars.stream().forEach( 
				(calendar) -> {
					this.populateRentalRecording(rentalRecordingList, calendar);
				
					int size = calendar.getBand().getSales().size();
					calendar.getBand().getSales().stream().forEach(
						(sale) -> {
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
					);
				}
			);
			
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
	
	private JasperPrint synthetical(Report report) {
		InputStream jasper = JasperUtil.getJasperFile("synthetic_report");
		
		Collection<SyntheticReport> reports = new ArrayList<>(0);
		
		try {
			Date start = formatterDB.parse(report.getInitDate());
			Date end = formatterDB.parse(report.getEndDate());
			
			Collection<Calendar> calendars = calendarService.findBy(new java.sql.Date(start.getTime()), new java.sql.Date(end.getTime()));
			
			SyntheticReport syntheticReport = new SyntheticReport(report.getInitDate(), report.getEndDate());
			
			calendars.stream().forEach(
				(calendar) -> {
					
					syntheticReport.setTotalRecording(Long.parseLong(String.valueOf(calendar.getRoom().getRecordings().size())));
					syntheticReport.setTotalRentals(Long.parseLong(String.valueOf(calendar.getBand().getRentals().size())));
					syntheticReport.setTotalSales(Long.parseLong(String.valueOf(calendar.getRoom().getSales().size())));
					
					calendar.getBand().getSales().stream().forEach(
						(sale) -> {
							long i = 0;
							syntheticReport.setTotalStock(++i);
						}
					);
				}
			);
			reports.add(syntheticReport);
			
			JasperUtil.setDataSource(reports);
			return JasperUtil.fillReport(jasper);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private Collection<RentalRecording> populateRentalRecording(Collection<RentalRecording> rentalRecordingList, Calendar calendar) {
		
		if("L".equals(calendar.getType())) {
			RentalRecording rentals = new RentalRecording("Locações");
			rentals.setSala(calendar.getRoom().getName());
			rentals.setBanda(calendar.getBand().getName());
			rentals.setData(formatter.format(calendar.getStartDatetime()));
			rentalRecordingList.add(rentals);
		} if("G".equals(calendar.getType())) {
			RentalRecording record = new RentalRecording("Gravações");
			record.setBanda(calendar.getBand().getName());
			record.setSala(calendar.getRoom().getName());
			record.setData(formatter.format(calendar.getStartDatetime()));
			rentalRecordingList.add(record);
		}
		
//		for(Rental rental : calendar.getRoom().getRentals()) {
//			RentalRecording rentals = new RentalRecording("Locações");
//			rentals.setBanda(rental.getBand().getName());
//			rentals.setSala(rental.getRoom().getName());
//			rentals.setTotal(String.valueOf(calendar.getRoom().getRentals().size()));
//			rentals.setData(formatter.format(calendar.getStartDatetime()));
//			rentalRecordingList.add(rentals);
//		}
//		
//		for(Recording recording : calendar.getRoom().getRecordings()) {
//			RentalRecording record = new RentalRecording("Gravações");
//			record.setBanda(recording.getBand().getName());
//			record.setSala(recording.getRoom().getName());
//			record.setTotal(String.valueOf(calendar.getRoom().getRecordings().size()));
//			rentalRecordingList.add(record);
//		}
		return rentalRecordingList;
	}
	
	
}