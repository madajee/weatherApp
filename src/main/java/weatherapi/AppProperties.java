package weatherapi;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {

	/*@Value("${mongodb}")
	private String mongodb;*/

	@Value("${appid}")
	private String appid;

	/*public String getMongodb() {
		return mongodb;
	}

	public void setMongodb(String mongodb) {
		this.mongodb = mongodb;
	}*/

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
}