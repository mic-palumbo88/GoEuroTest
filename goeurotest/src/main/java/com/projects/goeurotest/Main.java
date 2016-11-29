package com.projects.goeurotest;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Main {

	static String url = "http://www.goeuro.com/api/v2/position/suggest/en/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cityName=null;
		if(args.length==0){
			while(cityName==null){
				  // Reading from System.in
				System.out.println("Insert the city name:  ");
				cityName = new Scanner(System.in).next();
			}	
		}
		else
			cityName=args[0];
		url+= cityName;
		
		//System.out.println("URL: "+url);
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
			//System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			CityJSonRead cityJsonRead = new CityJSonRead();
	        Map<String, City> customers =cityJsonRead.readCityData(response.getEntity().getContent());
	        if(customers.size()>0){
	        	System.out.println("Number cities found in the database: "+customers.size());
	        	CityWriter cityWriter= new CityWriter(cityName);
	        	customers.entrySet().stream().forEach(cityWriter.printit);
	        	cityWriter.printOnFile();
	            }
	        else System.err.println("NO CITY "+cityName+" FOUND");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
