package com.hornung.roadiestudio.report;

public enum Type {

	ANALYTICAL("Analítico"),
	SYNTHETICAL("Sintético");
	
	private String description;
	
	private Type(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}