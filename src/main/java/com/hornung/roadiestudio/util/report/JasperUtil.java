package com.hornung.roadiestudio.util.report;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperUtil {
	
	private static JRDataSource dataSource;
	private static Map<String, Object> parameter;
	
	private JasperUtil() {
	}

	public static InputStream getJasperFile(String fileName) {
		try {
			InputStream jasper = JasperUtil.class.getResourceAsStream(String.format("/report/%s.jasper", fileName));
			
			return jasper;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(String.format("Erro ao tentar carregar o arquivo %s.jasper", fileName));
		}
	}
	
	public static void setDataSource(Collection<?> beanCollection) {
		dataSource = new JRBeanCollectionDataSource(beanCollection);
	}
	
	public static JasperPrint fillReport(InputStream jasper) {
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(jasper, parameter, dataSource);
		} catch (JRException e) {
			clearParameter();
			throw new RuntimeException(e.getMessage(), e);
		}
		clearParameter();
		return jasperPrint;
	}
	
	public static void setParameter(String key, Object value) {
		if(Objects.isNull(parameter))
			parameter = new HashMap<>(0);
		parameter.put(key, value);
	}
	
	private static void clearParameter() {
		parameter.clear();
		if(!parameter.isEmpty()) 
			parameter = null;
	}
	
}
