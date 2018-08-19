package com.query.api.themoviedb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	private String title;
	private String release_date;
	private Integer vote_count;
	
	public Movie() {
		
	}
	
	public Movie( String title, String release_date, Integer vote_count) {
		this.title = title;
		this.release_date = release_date;
		this.vote_count = vote_count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelease_date() {
		return release_date;
	}
	
	public Integer getYear() {
		
		if( null != release_date ) {
			return Integer.parseInt( release_date.substring(0, 4) );
		}
		
		return null;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public Integer getVote_count() {
		return vote_count;
	}

	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
}
