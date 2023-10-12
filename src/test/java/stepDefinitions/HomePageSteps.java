package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.ListingPage;
import pageObjects.ResultsPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class HomePageSteps {

    WebDriver driver;

    HomePage hp;
    ResultsPage rp;
    ListingPage lp;
    Properties p;
    Logger logger; //for logging
    String br; //to store browser name


    @Before
    public void setup() throws IOException
    {
        //for logging
        logger= LogManager.getLogger(this.getClass());

        //Reading config.properties (for browser)
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\resources\\config.properties");
        p=new Properties();
        p.load(file);
        br=p.getProperty("browser");


        switch (br) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {

            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());

        }
        driver.quit();
    }


    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        switch (br) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @And("user navigates to Daft homepage url {string}")
    public void user_navigates_to_daft_homepage_url(String url) throws InterruptedException {
        hp=new HomePage(driver);
        hp.navigateToHomepage(url);
    }

    @When("user searches for county {string} in the input field")
    public void user_searches_for_county_in_the_input_field(String location) throws InterruptedException {
        hp = new HomePage(driver);
        hp.enterDesiredLocation(location);
    }

    @And("user clicks on the desired location from the dropdown suggestions")
    public void user_clicks_on_the_desired_location_from_the_dropdown_suggestions() throws InterruptedException {
        hp.clickSuggestedLocation();
    }

    @Then("search results should be displayed for this location")
    public void search_results_should_be_displayed_for_this_location() throws InterruptedException {
        Thread.sleep(2000);
        rp = new ResultsPage(driver);
        int count = rp.setSearchResults();
        if(count > 0) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
    @When("user clicks on the filter option and applies the {string} filter")
    public void user_clicks_on_the_filter_option_and_applies_the_filter(String filter) {
        rp = new ResultsPage(driver);
        rp.setClickFilter();
        rp.setScrollToElement();
        rp.setKeywordInputString(filter);
        rp.setClickShowResults();
    }

    @Then("search results should be displayed for the filter")
    public void search_results_should_be_displayed_for_the_filter() {
        rp = new ResultsPage(driver);
        int count = rp.setSearchResults();
        if(count > 0) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    @When("user opens a search result")
    public void user_opens_a_search_result() throws InterruptedException {
        Thread.sleep(5000);
        rp = new ResultsPage(driver);
        rp.clickOnFirstResult();
    }

    @Then("advert description should contain the {string} keyword")
    public void advert_description_should_contain_the_keyword(String filter) {
        rp = new ResultsPage(driver);
        rp.setScrollToFirstResultElement();
        rp.clickOnFirstResult();

        lp = new ListingPage(driver);
        lp.setScrollToDescElement();

        boolean result1 = lp.setCapturePropertyDescription(filter);

        System.out.println("********************" +result1);

        lp.setScrollToPropertyElement();
        boolean result2 = lp.setCapturePropertyFeatures(filter);
        System.out.println("********************" +result2);

        if (result1 || result2) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
