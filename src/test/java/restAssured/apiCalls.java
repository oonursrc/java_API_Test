package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.io.IOException;

import common.ReadConfigData;

public class apiCalls {

	public apiCalls() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private Response response;
	private RequestSpecification request;
	ReadConfigData readconfigdata = new ReadConfigData();

	public void getBaseURL() {

		RestAssured.baseURI = readconfigdata.getBASE_URL();
		request = RestAssured.given();

	}

	public void setHeaderContentType() {
		request.header("Content-Type", "application/json");

	}

	public int queryuser(String username) {
		response = request.queryParam("username", username).get(readconfigdata.getDETAILS_URL());
		System.out.println("Response for user ** " + username + " ** is" + response.asString());
		
		return response.getStatusCode();

	}

	public int signUpUser(String infodict) {
		request.body(infodict);
		response = request.post();

		return response.getStatusCode();

	}

	public int deleteuser() {
		request.auth().preemptive().basic(readconfigdata.getTestUser(), readconfigdata.getTestPassword());
		request.body(response.getBody().asString()); // reponse comes from queryuser
		response = request.delete();

		return response.getStatusCode();
	}

	public Response queryOneUser(String username) {
		response = given().log().all().queryParam("username", username).when()
				.get(readconfigdata.getBASE_URL() + readconfigdata.getDETAILS_URL()).then().log().status()
				// .statusCode(HttpStatus.SC_OK)
				.extract().response();
		response.prettyPrint();

		return response;

	}

}
