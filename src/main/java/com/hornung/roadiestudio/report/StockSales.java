package com.hornung.roadiestudio.report;

import java.io.Serializable;

import com.hornung.roadiestudio.util.Field;
import com.hornung.roadiestudio.util.ForJasperReport;

@ForJasperReport(jrxml = "stock_sales_analytical_report")
public class StockSales implements Serializable {

	private static final long serialVersionUID = -1772721458938793526L;

	@Field
	private String title;

	@Field
	private String column1;
	
	@Field
	private String column2;
	
	@Field
	private String column3;

	@Field
	private String row1;
	
	@Field
	private String row2;
	
	@Field
	private String row3;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getRow1() {
		return row1;
	}

	public void setRow1(String row1) {
		this.row1 = row1;
	}

	public String getRow2() {
		return row2;
	}

	public void setRow2(String row2) {
		this.row2 = row2;
	}

	public String getRow3() {
		return row3;
	}

	public void setRow3(String row3) {
		this.row3 = row3;
	}
}