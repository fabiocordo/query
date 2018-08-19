package com.query.api;

import java.util.Arrays;
import java.util.Optional;

public class Helper {

	public static IWizardApi getAPI(String api) {
		
		 Optional<APIs> apiSelected = Arrays.stream(APIs.values()).filter(y -> y.name().equals(api.toUpperCase() )).findFirst();
		 return apiSelected.isPresent() ? apiSelected.get().getApi() : null;
    }	

}
