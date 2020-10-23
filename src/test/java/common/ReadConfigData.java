package common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigData {
	
	ConfigData configdata= ConfigData.getInstance();
	
	
	private final String BASE_URL;
	private final String ACCESS_URL;
	private final String ALL_URL;
	private final String DETAILS_URL;
	
	private final String adminUser;
	private final String adminPassword;
	private final String testUser;
	private final String testPassword;
	private final String devUser;
	private final String devPassword;
	private final String wrongUser;
	private final String wrongPassword;
	
	
	public ReadConfigData() throws FileNotFoundException, IOException{
		//super();
		InputStream in = this.getClass().getResourceAsStream("/config.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		BASE_URL= prop.getProperty("base_url");
		ACCESS_URL= prop.getProperty("access_url");
		ALL_URL= prop.getProperty("all_url");	
		DETAILS_URL= prop.getProperty("details_url");
		
		
		adminUser = prop.getProperty("admin.username");
		adminPassword = prop.getProperty("admin.password");
		
		testUser = prop.getProperty("test.username");
		testPassword = prop.getProperty("test.password");
		
		devUser = prop.getProperty("dev.username");
		devPassword = prop.getProperty("dev.password");
		
		wrongUser = prop.getProperty("wrong.username");
		wrongPassword = prop.getProperty("wrong.password");
		
		
		setBASE_URL(BASE_URL);
		setACCESS_URL(ACCESS_URL);
		setALL_URL(ALL_URL);		
		setDETAILS_URL(DETAILS_URL);

		setAdminUser(adminUser);
		setTestUser(testUser);
		setDevUser(devUser);
		setWrongUser(wrongUser);
		
		setAdminPassword(adminPassword);
		setTestPassword(testPassword);
		setDevPassword(devPassword);
		setWrongPassword(wrongPassword);
	
	}

	public String getBASE_URL() {
		return configdata.getBASE_URL();
	}
	public void setBASE_URL(String base_URL) {
		configdata.setBASE_URL(base_URL);
	}
	
	public String getACCESS_URL() {
		return configdata.getACCESS_URL();
	}
	public void setACCESS_URL(String access_URL) {
		configdata.setACCESS_URL(access_URL);
	}
	
	public String getALL_URL() {
		return configdata.getALL_URL();
	}
	public void setALL_URL(String all_URL) {
		configdata.setALL_URL(all_URL);
	}
	
	public String getDETAILS_URL() {
		return configdata.getDETAILS_URL();
	}
	public void setDETAILS_URL(String details_URL) {
		configdata.setDETAILS_URL(details_URL);
	}
	
	public String getAdminUser() {
		return configdata.getAdminUser();
	}
	public void setAdminUser(String adminUser) {
		configdata.setAdminUser(adminUser);
	}
	
	public String getAdminPassword() {
		return configdata.getAdminPassword();
	}
	public void setAdminPassword(String adminPassword) {
		configdata.setAdminPassword(adminPassword);
	}
	
	public String getTestUser() {
		return configdata.getTestUser();
	}
	public void setTestUser(String testUser) {
		configdata.setTestUser(testUser);
	}
	
	public String getTestPassword() {
		return configdata.getTestPassword();
	}
	public void setTestPassword(String testPassword) {
		configdata.setTestPassword(testPassword);
	}
	
	public String getDevUser() {
		return configdata.getDevUser();
	}
	public void setDevUser(String devUser) {
		configdata.setDevUser(devUser);
	}
	
	public String getDevPassword() {
		return configdata.getDevPassword();
	}
	public void setDevPassword(String devPassword) {
		configdata.setDevPassword(devPassword);
	}
	
	public String getWrongUser() {
		return configdata.getWrongUser();
	}
	public void setWrongUser(String wrongUser) {
		configdata.setWrongUser(wrongUser);
	}
	
	public String getWrongPassword() {
		return configdata.getWrongPassword();
	}
	public void setWrongPassword(String wrongPassword) {
		configdata.setWrongPassword(wrongPassword);
	}
	
	
	

}
