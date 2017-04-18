package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	//private static AppProperties app;

	/*@Autowired
    public void setApp(AppProperties app) {
        this.app = app;
    }*/

	@Autowired
    OpenWeatherMapAPI openWeatherMapAPI;

    @Autowired
    OpenWeatherMapPayloadToPojo openWeatherMapPayloadToPojo;

    @Autowired
    OpenWeatherMapAPIPojoToWeatherDto openWeatherMapAPIPojoToWeatherDto;

    @Autowired
    AppProperties app;
	
	public static void main(String[] args) {
		    SpringApplication.run(Application.class, args);

		    log.info("********Start Logging From Main Method******");
		    log.info("********Hello Spring Boot Seed******");
		    log.info("********End Logging From Main Method********");
		    
		}

	@Bean
    public CommandLineRunner run() throws Exception {

	    String appid = app.getAppid();
	    log.info("AppID: " + appid);
	    ResponseEntity<String> response = openWeatherMapAPI.getWeatherByCity(appid);
	    String payload = response.getBody();
	    System.out.println("OpenWeatherMapAPI Payload" + payload);

	    OpenWeatherMapAPIPojo openWeatherMapAPIPojo = openWeatherMapPayloadToPojo.mapOpenWeatherPayloadToPojo(payload);
	    System.out.println("Base: " + openWeatherMapAPIPojo.getBase());
	    System.out.println("CityName: " + openWeatherMapAPIPojo.getName());
	    System.out.println("Coord Lon: " + openWeatherMapAPIPojo.getCoord().getLon());

	    WeatherDto weatherDto = openWeatherMapAPIPojoToWeatherDto.transformOpenWeatherMapAPIPojoToWeatherDto(openWeatherMapAPIPojo);
	    System.out.println("CityName1: " + weatherDto.getCityName());
	    //log.info("MongoDBURL: " + app.getMongodb());
	    return null;

    }

	public String convertToUpperCase (String str){
 	   return str.toUpperCase();
	}

}