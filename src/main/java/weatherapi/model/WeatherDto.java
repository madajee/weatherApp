package weatherapi;

public class WeatherDto {

	private String cityName;
	private String cityTemp;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityTemp() {
		return cityTemp;
	}

	public void setCityTemp(String cityTemp) {
		this.cityTemp = cityTemp;
	}
}