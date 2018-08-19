package com.query.api.omdbapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	
	@JsonProperty("Search")
	private List<Movie> search;
	
	@JsonProperty("totalResults")
	private Integer totalResults;

	public Response() {
		
	}
	
	public Response(List<Movie> search, Integer totalResults) {
		
		this.search = search;
		this.totalResults = totalResults;
	}
	
	public List<Movie> getSearch() {
		return search;
	}
	public void setSearch(List<Movie> search) {
		this.search = search;
	}
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
}
