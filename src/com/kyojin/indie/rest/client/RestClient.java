package com.kyojin.indie.rest.client;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
	
	private URL url;
	private HttpURLConnection connection;
	private BufferedReader br;
	private HttpVerb verb;
	
	public RestClient(URL url) {
		super();
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public HttpURLConnection getConnection() {
		return connection;
	}

	public void setConnection(HttpURLConnection connection) {
		this.connection = connection;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}
	
	public HttpVerb getVerb() {
		return verb;
	}

	public void setVerb(HttpVerb verb) {
		this.verb = verb;
	}
	
	public void connection() {
		
	}

	
	

}
