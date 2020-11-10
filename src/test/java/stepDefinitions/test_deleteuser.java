package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.*;
import restAssured.apiCalls;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.junit.runner.RunWith;
import common.ReadConfigData;

@RunWith(Cucumber.class)
public class test_deleteuser {

	public test_deleteuser() throws IOException {
		super();
	}

	protected ReadConfigData readconfigdata;

	static Logger logger = LogManager.getLogger(test_deleteuser.class);
	apiCalls apicall = new apiCalls();
	int respCode;

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

	 @Given("^Delete User API is going to be executed$")
	    public void delete_user_api_is_going_to_be_executed() throws Throwable {
		 logger.info("Delete a user will be executed");
		 apicall.getBaseURL();
		 apicall.setHeaderContentType();
	    }

	    @When("^Query User and Delete User API executed with for an existing user (.+)$")
	    public void query_user_and_delete_user_api_executed_with_for_an_existing_user(String username)  {
	    	respCode= apicall.queryuser(username);
			System.out.println("Query user: " + username + ", Status Code is: " + respCode);
	    }

	    @Then("^Delete User for (.+) is successful$")
	    public void delete_user_for_is_successful(String username) {
	    	if(respCode ==HttpStatus.SC_OK) { //resCode of query user
	    		respCode= apicall.deleteuser();
	    		System.out.println("Delete user: " + username + ", Status Code is: " + respCode);
	    		assertEquals(respCode, HttpStatus.SC_OK); //resCode of delete request
	    	}
	    }

	@After
	public void afterTest() {
		logger.info("=================== Test Set Ends ===================");
	}
}