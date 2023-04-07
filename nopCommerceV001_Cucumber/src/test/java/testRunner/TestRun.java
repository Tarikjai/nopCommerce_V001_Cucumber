package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features={".//Features/customers.feature",".//Features/login.feature"},
	//	features={".//Features/customers.feature"},
				//features={".//Features/"},
		glue={"stepDefinitions"},
		monochrome=true,
		dryRun=false,
		plugin={"pretty","html:test-output"},
		tags= "@sanity"
		)
public class TestRun {


}
