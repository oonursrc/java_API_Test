package cucumberOptions;

import org.junit.runner.RunWith;


import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/deleteuser.feature"},
		glue = "stepDefinitions"
		)
public class TestRunner_deleteuser {

}
