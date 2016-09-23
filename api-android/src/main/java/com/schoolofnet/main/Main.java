package com.schoolofnet.main;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.Session;

import com.schoolofnet.model.HibernateSession;

public class Main {
	
	public static final String BASE_URI = "http://localhost:8080/api/";
	
	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("com.schoolofnet");
		
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}
	
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		
		System.out.println("Jersey app started at: " + BASE_URI + "to shutdown, please enter!");
		System.in.read();
		
		server.shutdown();
	}
}
