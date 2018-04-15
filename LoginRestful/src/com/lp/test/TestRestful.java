package com.lp.test;
import java.awt.PageAttributes.MediaType;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

public class TestRestful {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget alvoWS = client.target(getURIBase());
		
		System.out.println(alvoWS.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class));
		
		
	}
	
	private static URI getURIBase(){
		return UriBuilder.fromUri("http://localhost:8080/LoginRestful/login").build();
	}

}
