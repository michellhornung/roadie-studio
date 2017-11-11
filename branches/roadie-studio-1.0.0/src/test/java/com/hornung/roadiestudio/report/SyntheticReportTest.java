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

public class SyntheticReportTest {

	@Test
	public void test() {
		
		try {
			Map<String, Object> parameter = new HashMap<>();
			
			InputStream jasper = this.getClass().getResourceAsStream("/report/synthetic_report.jasper");
			
			
			Collection<SyntheticReport> syntheticReports = new ArrayList<>(0);
			
			SyntheticReport analyticalReport = new SyntheticReport("01/11/2017", "10/11/2017");
			analyticalReport.setTotalRentals(20L);
			analyticalReport.setTotalRecording(20L);
			analyticalReport.setTotalStock(20L);
			analyticalReport.setTotalSales(50L);
			
			syntheticReports.add(analyticalReport);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(syntheticReports);
			
			JasperPrint print = JasperFillManager.fillReport(jasper, parameter, dataSource);
			
			byte[] pdf = JasperExportManager.exportReportToPdf(print);
			
			IOUtils.copy(new ByteArrayInputStream(pdf), new FileOutputStream("./target/relatorio_sintetico.pdf"));
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
