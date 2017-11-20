package com.hornung.roadiestudio.report;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.hornung.roadiestudio.util.report.JasperUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

public class AnalyticalReportTest {

	@Test
	public void test() {
		
		try {
			InputStream jasper = JasperUtil.getJasperFile("analytical_report");
			
			InputStream subReportRentalRecording = JasperUtil.getJasperFile("rentals_recording_analytical_report");
			InputStream subReportStock = JasperUtil.getJasperFile("stock_report");
			InputStream subReportSales = JasperUtil.getJasperFile("sales_report");
			
			JasperUtil.setParameter("subReportRentalRecording", subReportRentalRecording);
			JasperUtil.setParameter("subReportStock", subReportStock);
			JasperUtil.setParameter("subReportSales", subReportSales);
			
			Collection<AnalyticalReport> analyticalReports = new ArrayList<>(0);
			Collection<Stock> stocks = new ArrayList<>(0);
			Collection<Sales> sales = new ArrayList<>(0);
			
			AnalyticalReport analyticalReport = new AnalyticalReport("01/11/2017", "10/11/2017");
			
			analyticalReport.setRentalRecordingList(getRentals());
			
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
			
			JasperUtil.setDataSource(analyticalReports);
			JasperPrint print = JasperUtil.fillReport(jasper);
			
//			byte[] pdf = JasperExportManager.exportReportToPdf(print);
//			IOUtils.copy(new ByteArrayInputStream(pdf), new FileOutputStream("./target/relatorio_analitico.pdf"));
			
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("./target/relatorio_analitico.pdf"));
			
			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);
			 
			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");
			 
			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);
			 
			exporter.exportReport();
			
			
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
	private Collection<RentalRecording> getRentals() {
		Collection<RentalRecording> rentalRecordings = new ArrayList<>(0);
		for(int i = 0; i <= 3; i ++) {
			RentalRecording rental = new RentalRecording("Locações");
			rental.setBanda("Locacao " + i);
//			rental.setData("02/11/2017");
			rental.setTotal("2");
			rental.setSala("Punk");
			rentalRecordings.add(rental);
		}
		
		for(int i = 0; i <= 3; i++) {
			RentalRecording recording = new RentalRecording("Gravações");
			recording.setBanda("gravacao " + i);
//			recording.setData("03/11/2017");
			recording.setTotal("5");
			recording.setSala("push");
			rentalRecordings.add(recording);
		}
		
		return rentalRecordings;
	}
	

}
