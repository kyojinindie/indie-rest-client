package com.kyojin.indie.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.kyojin.indie.logo.Logo;
import com.kyojin.indie.rest.client.RestClientGet;
import com.kyojin.indie.rest.client.RestClientPost;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		Logo logo = new Logo();
		Scanner sc = new Scanner(System.in);
		logo.printLogo();
		System.out.println();
		System.out.println("URL:");
		String url = sc.nextLine();
		System.out.println("Method:");
		String method = sc.nextLine();
		
		switch (method) {
		case "GET":
			RestClientGet restClientGet = new RestClientGet(new URL(url));
			restClientGet.connection();
			break;
		case "POST":
			System.out.println("Body:");
			String body = sc.nextLine();
			RestClientPost restClientPost = new RestClientPost(new URL(url), body);
			restClientPost.connection();
			break;

		default:
			break;
		}
		
		
		

	}

}
