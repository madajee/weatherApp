package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OpenWeatherMapPayloadToPojo {

	private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapPayloadToPojo.class);

	public OpenWeatherMapAPIPojo mapOpenWeatherPayloadToPojo(String payload) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		OpenWeatherMapAPIPojo openWeatherMapAPIPojo = mapper.readValue(payload, OpenWeatherMapAPIPojo.class);
		return openWeatherMapAPIPojo;
	}
}