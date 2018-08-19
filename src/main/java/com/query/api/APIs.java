package com.query.api;

import com.query.api.omdbapi.Omdbapi;
import com.query.api.themoviedb.Themoviedb;

public enum APIs {
	
	OMDBAPI{
		
		public IWizardApi getApi() {
			return Omdbapi.getInstance();			
		}
		
		
	}, MOVIEDB{
		
		public IWizardApi getApi() {
			return Themoviedb.getInstance();
		}
	};
	
	public abstract IWizardApi getApi();
}
