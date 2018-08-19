package com.query.api.themoviedb;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.query.api.IWizardApi;
import com.query.api.themoviedb.model.Response;
import com.query.model.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class Themoviedb  implements IWizardApi{

	private String URL = "https://api.themoviedb.org/3/search/movie?api_key=0558db3273d250ad52381a15ba377866&query=%s";
	private final String USER_AGENT = "Mozilla/5.0";

	private Themoviedb() {
		
	}

	public static Themoviedb getInstance() {
		return new Themoviedb();
	}

	@Override
	public String getURL(String movie) {
		
		try {
		
			return String.format(URL, URLEncoder.encode(movie, "UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Result> findMovie(String movie) {

		try {
			
			String charset = "UTF-8";
			
			URL obj = new URL(getURL(movie));

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(false);
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Charset", charset);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();

			ObjectMapper mapper = new ObjectMapper();
			Response resp = mapper.readValue(response.toString(), Response.class);
			
			if( null != resp && resp.getResults().size() > 0) {
				
				List<Result> list = new ArrayList<Result>();
				
				resp.getResults().stream().forEach( c -> list.add( new Result( c.getTitle() , c.getYear()) ) );
				
				return list;
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
	}
}
