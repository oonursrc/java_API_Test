package cucumberOptions;

import org.junit.runner.RunWith;


import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/getuserinformation.feature"},
		glue = "stepDefinitions"
		)
public class TestRunner_a_queryOneUser {

}
