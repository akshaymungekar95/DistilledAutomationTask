package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

					features= {".//src/test/java/features"},
					glue={"stepDefinitions"},
					plugin= {
							"pretty",
							"html:target/cucumber-reports/CucumberTestReport.html",
							"html:target/cucumber-reports/index.html",
							"json:target/cucumber-reports/CucumberTestReport.json",
							"rerun:target/cucumber-reports/rerun.txt"
							},
					dryRun=false,
					monochrome=true,
					publish=true,
					tags="@smoke or @regression"
		)
public class TestRunner {
}
