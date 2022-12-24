package stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FEATURE",
				glue = {"stepdefinition","project.repositary","project.resource"}
				,plugin = {"html:target","json:target/reports.json"}
				,dryRun = false,
						monochrome = true
)
public class TestRunner {

}
