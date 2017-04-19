package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.http.ResponseEntity;

@Component
public class WeatherService {

	private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

	@Autowired
	OpenWeatherMapAPI openWeatherMapAPI;

	@Autowired
    OpenWeatherMapPayloadToPojo openWeatherMapPayloadToPojo;

    @Autowired
    OpenWeatherMapAPIPojoToWeatherDto openWeatherMapAPIPojoToWeatherDto;

	@Autowired
    AppProperties app;

	public String getWeatherByCity(String cityName) throws Exception {

		log.info("In Weather Service Start");
		String appid = app.getAppid();
		String city = app.getDefaultCity();
		String unit = app.getDefaultUnit();
		if (cityName != null)
			city = cityName;  
	    ResponseEntity<String> response = openWeatherMapAPI.getWeatherByCity(appid,city,unit);
	    String payload = response.getBody();
	    System.out.println("OpenWeatherMapAPI Payload" + payload);
	    OpenWeatherMapAPIPojo openWeatherMapAPIPojo = openWeatherMapPayloadToPojo.mapOpenWeatherPayloadToPojo(payload);
	    WeatherDto weatherDto = openWeatherMapAPIPojoToWeatherDto.transformOpenWeatherMapAPIPojoToWeatherDto(openWeatherMapAPIPojo);
	    log.info("In Weather Service Stop");
	    return weatherDto.getCityTemp();
	}
}