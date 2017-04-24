package weatherapi;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTest {

	@Autowired
    WeatherService weatherService;

    @Test
    public void testGetWeatherByCity() throws Exception {
    	String cityName = "";
    	String cityTemp = weatherService.getWeatherByCity(cityName);
    	System.out.println("WeatherServiceTest City Temp: " + cityTemp);
    }
    

}