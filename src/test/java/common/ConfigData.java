package common;

public class ConfigData {
	

	private static ConfigData single_instance = null;
	
	
	
	private  String BASE_URL;
	private  String ACCESS_URL;
	private  String ALL_URL;
	private  String DETAILS_URL;
	
	
	private  String adminUser;
	private  String adminPassword;
	private  String testUser;
	private  String testPassword;
	private  String devUser;
	private  String devPassword;
	private  String wrongUser;
	private  String wrongPassword;
	

	public ConfigData() {
		
		/*
		 * this.BASE_URL = BASE_URL; this.ACCESS_URL = ACCESS_URL; this.ALL_URL =
		 * ALL_URL; this.DETAILS_URL = DETAILS_URL; this.adminUser = adminUser;
		 * this.adminPassword = adminPassword; this.testUser = testUser;
		 * this.testPassword = testPassword; this.devUser = devUser; this.devPassword =
		 * devPassword; this.wrongUser = wrongUser; this.wrongPassword = wrongPassword;
		 */
	}
	



	public static ConfigData getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new ConfigData(); 
  
        return single_instance; 
    }
	

	public String getBASE_URL() {
		return BASE_URL;
	}
	public void setBASE_URL(String base_URL) {
		BASE_URL = base_URL;
	}
	
	public String getACCESS_URL() {
		return ACCESS_URL;
	}
	public void setACCESS_URL(String access_URL) {
		ACCESS_URL = access_URL;
	}
	
	public String getALL_URL() {
		return ALL_URL;
	}
	public void setALL_URL(String all_URL) {
		ALL_URL = all_URL;
	}
	
	public String getDETAILS_URL() {
		return DETAILS_URL;
	}
	public void setDETAILS_URL(String details_URL) {
		DETAILS_URL = details_URL;
	}
	
	public String getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public String getTestUser() {
		return testUser;
	}
	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}
	
	public String getTestPassword() {
		return testPassword;
	}
	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}
	
	public String getDevUser() {
		return devUser;
	}
	public void setDevUser(String devUser) {
		this.devUser = devUser;
	}
	
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	
	public String getWrongUser() {
		return wrongUser;
	}
	public void setWrongUser(String wrongUser) {
		this.wrongUser = wrongUser;
	}
	
	public String getWrongPassword() {
		return wrongPassword;
	}
	public void setWrongPassword(String wrongPassword) {
		this.wrongPassword = wrongPassword;
	}
	
	
	
	
	
	
	


}
