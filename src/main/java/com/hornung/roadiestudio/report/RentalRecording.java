package com.hornung.roadiestudio.report;

import java.io.Serializable;

import com.hornung.roadiestudio.util.Field;
import com.hornung.roadiestudio.util.ForJasperReport;

@ForJasperReport(jrxml = "rentals_recording_analytical_report")
public class RentalRecording implements Serializable {

	private static final long serialVersionUID = -6521999113934833432L;
	
	@Field
	private String title;
	
	@Field
	private String total;
	
	@Field
	private String data;
	
	@Field
	private String sala;
	
	@Field
	private String banda;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

}