package stepDefinitions;

import enums.Browsers;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testBase.TestBase;
import java.io.IOException;

public class ServiceHooks {
	TestBase testBase;

	@Before
	public void initializeTest() throws IOException {
		testBase = new TestBase();
        testBase.propertyInitializer();
		testBase.selectBrowser(Browsers.CHROME.name());
	}

	@After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {

            TakesScreenshot ts=(TakesScreenshot) TestBase.driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
		TestBase.driver.quit();
    }
}
