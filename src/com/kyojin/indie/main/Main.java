package com.kyojin.indie.main;

import java.net.MalformedURLException;
import java.net.URL;

import com.kyojin.indie.logo.Logo;
import com.kyojin.indie.rest.client.RestClientGet;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		Logo logo = new Logo();
		RestClientGet restClientGet = new RestClientGet(new URL("http://localhost:8080/api/v1/person"));
		logo.printLogo();
		restClientGet.connection();

	}

}
