package weatherapi;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class OpenWeatherMapAPITest{

	@Autowired
    AppProperties app;

	@Test
    public void getWeatherByCityReturnsOK() {

    	String appid = app.getAppid();
    	String city = "Atlanta";
    	String unit = "metric";
	    System.out.println("AppID: " + appid);
    	OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI();
    	ResponseEntity<String> response;
	    response = openWeatherMapAPI.getWeatherByCity(appid, city, unit);
	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}