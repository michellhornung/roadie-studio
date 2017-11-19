package com.hornung.roadiestudio.report;

public class Report extends AbstractReport {

	private static final long serialVersionUID = -9044753397639858319L;
	
	public Report() {
		super();
	}

	private Type type;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}