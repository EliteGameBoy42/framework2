package Runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resouces/Feature/FBlogin.feature", glue = {
		"Step" }, format = { "pretty", "html:target/cucumber" }, tags="@Smoke, @fail")

public class DefaultRunner extends AbstractTestNGCucumberTests {

}

