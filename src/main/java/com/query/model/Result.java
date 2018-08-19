package com.query.model;

public class Result {
	
	private String title;
	private Integer year;
	
	public Result() {
		
	}

	public Result( String title, Integer year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Title: " + this.title + " - Year: " + this.year;
	}
}
