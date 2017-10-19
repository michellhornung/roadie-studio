package com.hornung.roadiestudio.model.dto;

public class Events {
	
	private int id;
	private String title;
	private String start;
	private String end;
	private String url;
	
	public Events(){
		
	}	
	
	public Events(int id, String title, String start, String end, String url) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.url = url;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}