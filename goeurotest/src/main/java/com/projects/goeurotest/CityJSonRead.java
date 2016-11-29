package com.projects.goeurotest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * GoEuroTest
 *
 */
public class CityJSonRead
{
	
	
	
    /**
     * method to read JSon file in local
     */
    public Function<String, File> getCitiesFileReader = filename -> {
        ClassLoader cl = getClass().getClassLoader();
        File cities = new File(cl.getResource(filename).getFile());
        return cities;
    };
    
    @SuppressWarnings("unchecked")
    public Map<String, City> readCityData(InputStream inputStream) {
        Map<String, City> cities = null;
        //File city = getCitiesFileReader.apply("cities.json");
        JSONParser parser = new JSONParser();
        Reader read;
		try {
			read = new InputStreamReader(inputStream); //from file read = FileInput(city)
			JSONArray jsonArray = (JSONArray) parser.parse(read);
			cities = (Map<String, City>) jsonArray.stream().collect(
                    Collectors.toMap(key_city, value_requestCity));
		} catch (IOException | org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return cities;
    }
    

	/**
     * Read the JSON entry and return city Id
     */
    private Function<JSONObject, Long> key_city = c -> (Long) ((JSONObject) c).get("_id");
 
    /**
     * Read the JSON entry and return the request city
     */
    private Function<JSONObject, City> value_requestCity = json -> {
        City c = new City();
        c.setId( (Long) json.get("_id"));
        c.setName((String) json.get("name"));
        c.setFullName((String) json.get("fullName"));
        c.setIata_airport_code((String) json.get("iata_airport_code"));
        c.setType((String) json.get("type"));
        c.setCountry((String) json.get("country"));
        
        final JSONObject geoPosition = (JSONObject) json.get("geo_position");
        GeoPosition geoPositionObj = new GeoPosition((Double) geoPosition.get("latitude"),
                									 (Double) geoPosition.get("longitude"));
        
        c.setGeoPosition(geoPositionObj);
        if(((String) json.get("location_id"))!=null)
        	c.setLocation_id(Integer.parseInt((String) json.get("location_id")));
        
        c.setInEurope((Boolean) json.get("inEurope"));
        c.setCountryCode((String) json.get("countryCode"));
        c.setCoreCountry((Boolean) json.get("coreCountry"));
        c.setDistance((String) json.get("distance"));
        
        return c;
    };
   
}



