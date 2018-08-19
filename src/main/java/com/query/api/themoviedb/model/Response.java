package com.query.api.themoviedb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	
	private Integer page;
	private Integer total_results;
	private Integer tota_pages;
	
	private List<Movie> results;
	
	public Response() {
		
	}
	
	public Response( Integer page, Integer total_results, Integer tota_pages, List<Movie> results ) {

		this.page = page;
		this.total_results = total_results;
		this.tota_pages = tota_pages;
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal_results() {
		return total_results;
	}

	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}

	public Integer getTota_pages() {
		return tota_pages;
	}

	public void setTota_pages(Integer tota_pages) {
		this.tota_pages = tota_pages;
	}

	public List<Movie> getResults() {
		return results;
	}

	public void setResults(List<Movie> results) {
		this.results = results;
	}	
}
