package com.query.api.omdbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Year")
	private Integer year;
	
	@JsonProperty("imdbID")
	private String imdbID;
	
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Poster")
	private String poster;
	
	public Movie() {
		
	}
	
	public Movie( String title, Integer year, String imdbID, String type, String poster ) {
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
		this.type = type;
		this.poster = poster;
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
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}	
}
