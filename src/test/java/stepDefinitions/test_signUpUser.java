package stepDefinitions;

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
public class test_signUpUser {

	public test_signUpUser() throws IOException {
		super();
	}

	protected ReadConfigData readconfigdata;

	static Logger logger = LogManager.getLogger(test_signUpUser.class);
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

	@Given("^SignUp is going to be executed$")
	public void signup_is_going_to_be_executed() {
		logger.info("SignUp a user will be executed");
		apicall.getBaseURL();
		apicall.setHeaderContentType();

	}

	@When("^SignUp API executed with for a new user with (.+) infos$")
	public void signup_api_executed_with_for_a_new_user_with_infos(String infodict) {
		respCode = apicall.signUpUser(infodict);
		System.out.println("SignUp a new user: " + infodict + ", Status Code is: " + respCode);
	}

	@Then("^Signup and query operation for (.+) is successful$")
	public void signup_and_query_operation_for_is_successful(String username) {

		if (respCode != HttpStatus.SC_BAD_REQUEST) {

			assertEquals(respCode, HttpStatus.SC_CREATED);
			respCode = apicall.queryuser(username);
			System.out.println("Query username: " + username + ", Status Code is: " + respCode);
			assertEquals(respCode, HttpStatus.SC_OK);
		}
		else {
			logger.info("SignUp operation failed");
		}

	}

	@After
	public void afterTest() {
		logger.info("=================== Test Set Ends ===================");
	}
}