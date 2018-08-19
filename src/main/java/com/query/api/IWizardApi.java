package com.query.api;

import java.util.List;

import com.query.model.Result;

public interface IWizardApi {
	
	public String getURL(String movie);

	public List<Result> findMovie( String movie);
}
