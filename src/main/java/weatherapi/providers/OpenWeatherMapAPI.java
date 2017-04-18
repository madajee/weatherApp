package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;*/

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;

@Component
//@Configuration
//@ComponentScan(basePackages = { "weatherapi"})
//@PropertySource("classpath:application.properties")
public class OpenWeatherMapAPI
{
	private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapAPI.class);

	//@Value("${mongodb.url}")
	//private String mongodbUrl;

	//@Autowired
	//private Environment env;

	public ResponseEntity<String> getWeatherByCity(String appid)
	{
		log.info("********Hello WeatherByCity******");
		//String mongodbUrl = env.getProperty("mongodb.url");
		//log.info("********MongoDBURL******" + mongodbUrl);
		//System.out.println("MongoDBURL: " + mongodbUrl);
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Atlanta&APPID="+appid+"&units=metric";
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, entity, String.class);
		return response;
	}

}