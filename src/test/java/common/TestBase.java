package common;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.apache.logging.log4j.LogManager;


public class TestBase {

	protected ReadConfigData readconfigdata;

	static Logger logger = LogManager.getLogger(TestBase.class);
	
	@Before
	public void beforeTest() {
		
		logger.info("=================== Test Set Begins ===================");
		try {
			readconfigdata = new ReadConfigData();
		} catch (FileNotFoundException e) {
			System.err.println("Credential file is not located");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void afterTest() {
		logger.info("=================== Test Set Ends ===================");
	}
	
	/*
	 * @Before(alwaysRun = true) public void beforeMethod() {
	 * logger.info("=================== Test Begins ==================="); }
	 * 
	 * @After(alwaysRun = true) public void AfterMethod() {
	 * logger.info("=================== Test Ends ==================="); }
	 */
}
