package stepDefinitions;

import io.cucumber.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.*;
import restAssured.apiCalls;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.junit.runner.RunWith;
import common.ReadConfigData;
import static org.junit.Assert.*;


@RunWith(Cucumber.class)
public class test_getuserinformation {

	public test_getuserinformation() throws IOException{
		super();
	}

	protected ReadConfigData readconfigdata;

	static Logger logger = LogManager.getLogger(test_getuserinformation.class);
	apiCalls apicall= new apiCalls();
	int respCode;
	
	@Before
	public void beforeTest() {
		
		logger.info("\n\n=================== Test Set Begins ===================");
		try {
			readconfigdata = new ReadConfigData();
		} catch (FileNotFoundException e) {
			System.err.println("Credential file is not located");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    @Given("^Query User Information is going to be executed$")
    public void query_user_information_is_going_to_be_executed()  {
        //System.out.println("Query User Information will be executed");
    	logger.info("Query User Information will be executed");
    	apicall.getBaseURL();
        
    }

    @When("^Query User Information API executed with (.+)$")
    public void query_user_information_api_executed_with(String username) {
    	//resp = apicall.queryOneUser(username);
    	
    	respCode= apicall.queryuser(username);
    	System.out.println("Query username: "+username+", Status Code is: "+ respCode);
    	
    	
    }

	@Then("^Query operation for (.+) is successful and response code is 200$")
    public void query_operation_for_is_successful_and_response_code_is_200(String username)  {
		assertEquals(respCode, HttpStatus.SC_OK);
		
    }

	@After
	public void afterTest() {
		logger.info("=================== Test Set Ends ===================\n\n");
	}
}