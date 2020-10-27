package com.kyojin.indie.rest.client;

import java.net.HttpURLConnection;
import java.net.URL;

public class RestClientGet extends RestClient {

	public RestClientGet(URL url) {
		super(url);
	}
	
	@Override
	public void connection() {
		try {
			setConnection((HttpURLConnection) getUrl().openConnection());
			getVerb();
			getConnection().setRequestMethod(HttpVerb.GET.name());
			getConnection().setRequestProperty("Accept", "application/json");
			
			if (getConnection().getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ getConnection().getResponseCode());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
