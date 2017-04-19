package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WeatherController {

	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/weatherapi/{cityName}", method = RequestMethod.GET)
    public String getWeatherByCity(@PathVariable("cityName") String cityName) throws Exception {

    	String cityTemp = weatherService.getWeatherByCity(cityName);
    	return cityTemp;
    }

}