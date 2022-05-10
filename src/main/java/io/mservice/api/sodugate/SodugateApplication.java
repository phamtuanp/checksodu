package io.mservice.api.sodugate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Pattern;

@SpringBootApplication
public class SodugateApplication {
	
	private static final String POST_API_URL = "https://daily.gate.vn/home";
	
	public static void main1(String[] args) {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("Cookie", "AuthID=t5akjauodc00h5ivse4txmg0")
				.uri(URI.create(POST_API_URL))
				.build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ObjectMapper mapper = new ObjectMapper();
	}
	
	
	private static String getContentFrom(String link) throws IOException {
		
		URL url = new URL(link);
		Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
		scanner.useDelimiter("\\\\Z");
		String content = scanner.next();
	    scanner.close();
		return content;
	}
	
	
	public static void main2(String[] args) throws IOException{
		@SuppressWarnings("unused")
		String content = getContentFrom("<https://daily.gate.vn/home/>");
		Pattern p = Pattern.compile("");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SodugateApplication.class, args);
	}

}
