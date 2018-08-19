package com.query.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.query.api.IWizardApi;
import com.query.model.Result;

@Service
public class RestClientService {

    public void search(IWizardApi iWizardApi, String movie) {

    	List<Result> listResults = iWizardApi.findMovie(movie);

    	if( null!= listResults && listResults.size() > 0 ) {
    		listResults.forEach( System.out::println );	
    	}
    	else {
    		System.out.println("Your search - " + movie + " - did not match any movie");
    	}
    }
}
