package com.kyojin.indie.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClientPost extends RestClient{
	
	private String body;
	
	public RestClientPost(URL url, String body) {
		super(url);
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public void connection() {
		try {
			setConnection((HttpURLConnection) getUrl().openConnection());
			getVerb();
			getConnection().setRequestMethod(HttpVerb.POST.name());
			getConnection().setDoOutput(true);
			getConnection().setDoInput(true);
			getConnection().setRequestProperty("Content-type", "application/json");
			getConnection().setRequestProperty("Accept", "*/*");
			
			OutputStreamWriter wr = new OutputStreamWriter(getConnection().getOutputStream());
			wr.write(this.body);
			wr.flush();
			
			setBr(new BufferedReader(new InputStreamReader(
					(getConnection().getInputStream()))));
			
			String output;
			System.out.println("Output from Server .... \n" + getConnection().getResponseCode());
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
