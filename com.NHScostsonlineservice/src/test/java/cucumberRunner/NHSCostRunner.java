package cucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue = {
		"stepdefinition" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"junit:target/CucumberTestReports/JunitReport.xml", "html:target/CucumberTestReports/HTMLReport.html",
				"json:target/CucumberTestReports/JsonReport.json" })
public class NHSCostRunner {

}





