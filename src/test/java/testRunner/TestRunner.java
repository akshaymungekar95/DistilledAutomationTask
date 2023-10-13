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
							"json:target/cucumber-reports/CucumberTestReport.json",
							"rerun:target/cucumber-reports/rerun.txt"
							},
					dryRun=false,
					monochrome=true,
					publish=true
					//tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {
}
