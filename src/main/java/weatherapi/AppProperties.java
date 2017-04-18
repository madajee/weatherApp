package weatherapi;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {

	/*@Value("${mongodb}")
	private String mongodb;*/

	/*public String getMongodb() {
		return mongodb;
	}

	public void setMongodb(String mongodb) {
		this.mongodb = mongodb;
	}*/

	@Value("${appid}")
	private String appid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Value("${defaultcity}")
	private String defaultcity;

	public String getDefaultCity() {
		return defaultcity;
	}

	public void setDefaultCity(String defaultcity) {
		this.defaultcity = defaultcity;
	}

	@Value("${defaultunit}")
	private String defaultunit;

	public String getDefaultUnit() {
		return defaultunit;
	}

	public void setDefaultUnit(String defaultunit) {
		this.defaultunit = defaultunit;
	}
}