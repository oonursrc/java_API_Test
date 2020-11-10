package cucumberOptions;

import org.junit.runner.RunWith;


import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/signupuser.feature"},
		glue = "stepDefinitions"
		)
public class TestRunner_b_signupuser {

}
