package weatherapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapAPIPojoToWeatherDto {

	private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapAPIPojoToWeatherDto.class);

	public WeatherDto transformOpenWeatherMapAPIPojoToWeatherDto(OpenWeatherMapAPIPojo inputPaylaod) throws Exception
	{
		WeatherDto outputPaylaod = new WeatherDto();
		outputPaylaod.setCityName(inputPaylaod.getName());
		outputPaylaod.setCityTemp(inputPaylaod.getMain().getTemp());
		return outputPaylaod;
	}
}