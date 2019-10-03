package weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.*;

@JsonIgnoreProperties({"weather", "wind", "clouds", "dt", "sys", "id", "cod", "visibility", "timezone"})
public class OpenWeatherMapAPIPojo {

	private String base;
	private String name;
	private Coord coord;
	private Main main;
	private TimeZone timezone;
	
	public TimeZone getTimeZone() {
		return timezone;
	}

	public void setTimeZone() {
		this.timezone = timezone;
	}


	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@JsonIgnoreProperties({"lat"})
	public class Coord {
		
		private String lon;
		//private String lat;

		public String getLon() {
			return lon;
		}

		public void setLon(String lon) {
			this.lon = lon;
		}

		/*public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}*/

	}

	@JsonIgnoreProperties({"pressure", "humidity", "temp_min", "temp_max"})
	public class Main {
		
		private String temp;

		public String getTemp() {
			return temp;
		}

		public void setTemp(String temp) {
			this.temp = temp;
		}

	}

}