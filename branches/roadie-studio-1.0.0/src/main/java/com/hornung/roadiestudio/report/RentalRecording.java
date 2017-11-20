package com.hornung.roadiestudio.report;

import java.io.Serializable;

import com.hornung.roadiestudio.util.report.Field;
import com.hornung.roadiestudio.util.report.JrXml;

@JrXml(name = "rentals_recording_analytical_report")
public class RentalRecording implements Serializable {

	private static final long serialVersionUID = -6521999113934833432L;
	
	@Field
	private String title;
	
	@Field
	private String total;
	
	@Field
	private String dataInicial;
	
	@Field
	private String dataFinal;
	
	@Field
	private String sala;
	
	@Field
	private String banda;
	
	@Field
	private String tipo;
	
	
	public RentalRecording() {
	}

	public RentalRecording(String title) {
		this.title = title;
	}

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

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}