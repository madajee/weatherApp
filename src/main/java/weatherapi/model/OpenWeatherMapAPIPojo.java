package weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"weather", "main", "wind", "clouds", "dt", "sys", "id", "cod", "visibility"})
public class OpenWeatherMapAPIPojo {

	private String base;
	private String name;
	private Coord coord;
	
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

}