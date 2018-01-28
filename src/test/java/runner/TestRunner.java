package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
		glue= {"stepsFile"},
		plugin = { "pretty" },
		monochrome = true
		)

public class TestRunner {

}
