package com.query.api.omdbapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.query.api.IWizardApi;
import com.query.api.omdbapi.model.Response;
import com.query.model.Result;

public class Omdbapi implements IWizardApi{
	
	private String URL = "http://www.omdbapi.com/?apikey=48d01235&type=movie&s=%s"; 
	
	private Omdbapi() {
		
	}
	
	public static Omdbapi getInstance() {
		return new Omdbapi();
	}

	@Override
	public String getURL(String movie) {
		return String.format(URL, movie);
	}

	@Override
	public List<Result> findMovie(String movie) {
		
		Response response = new RestTemplate().getForObject(getURL(movie), Response.class);
		
		if( null != response && null != response.getSearch() && response.getSearch().size() > 0) {
			
			List<Result> list = new ArrayList<Result>();
			
			response.getSearch().stream().forEach( c -> list.add( new Result( c.getTitle() , c.getYear()) ) );
			
			return list;
		}

		return null;
	}
}
