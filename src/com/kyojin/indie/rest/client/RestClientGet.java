package com.kyojin.indie.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
			
			setBr(new BufferedReader(new InputStreamReader(
					(getConnection().getInputStream()))));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = getBr().readLine()) != null) {
				System.out.println(output);
			}

			getConnection().disconnect();
		} catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
	}
		
}
