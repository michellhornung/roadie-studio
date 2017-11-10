package com.hornung.roadiestudio.report;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class AnalyticalReportTest {

	@Test
	public void test() {
		
		try {
			Map<String, Object> parameter = new HashMap<>();
			
			InputStream jasper = this.getClass().getResourceAsStream("/report/analytical_report.jasper");
			InputStream subReportRentalRecording = this.getClass().getResourceAsStream("/report/rentals_recording_analytical_report.jasper");
			InputStream subReportStock = this.getClass().getResourceAsStream("/report/stock_report.jasper");
			InputStream subReportSales = this.getClass().getResourceAsStream("/report/sales_report.jasper");
			
			parameter.put("subReportRentalRecording", subReportRentalRecording);
			parameter.put("subReportStock", subReportStock);
			parameter.put("subReportSales", subReportSales);
			
			Collection<AnalyticalReport> analyticalReports = new ArrayList<>(0);
			Collection<RentalRecording> rentalRecordings = new ArrayList<>(0);
			Collection<Stock> stocks = new ArrayList<>(0);
			Collection<Sales> sales = new ArrayList<>(0);
			
			AnalyticalReport analyticalReport = new AnalyticalReport("01/11/2017", "10/11/2017");
			
			RentalRecording rental = new RentalRecording("Locações");
			rental.setBanda("OffSpring");
			rental.setData("02/11/2017");
			rental.setTotal("2");
			rental.setSala("Punk");
			rentalRecordings.add(rental);
			
			RentalRecording recording = new RentalRecording("Gravações");
			recording.setBanda("OffSpring");
			recording.setData("03/11/2017");
			recording.setTotal("5");
			recording.setSala("push");
			rentalRecordings.add(recording);
			analyticalReport.setRentalRecordingList(rentalRecordings);
			
			Stock stock = new Stock();
			stock.setName("Coca-Cola");
			stock.setDate("10/11/2017");
			stock.setTotal("8");
			stocks.add(stock);
			analyticalReport.setStockList(stocks);
			
			Sales sale = new Sales();
			sale.setName("Coca-cola");
			sale.setDescription("Venda de coca-cola");
			sale.setValue("3,50");
			sales.add(sale);
			analyticalReport.setSalesList(sales);
			
			analyticalReports.add(analyticalReport);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(analyticalReports);
			
			JasperPrint print = JasperFillManager.fillReport(jasper, parameter, dataSource);
			
			byte[] pdf = JasperExportManager.exportReportToPdf(print);
			
			IOUtils.copy(new ByteArrayInputStream(pdf), new FileOutputStream("./target/relatorio_analitico.pdf"));
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
