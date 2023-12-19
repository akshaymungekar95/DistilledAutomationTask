package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import testBase.TestBase;



public class HomePageSteps extends TestBase {

    HomePage hp;

    @Given("user navigates to Daft homepage url")
    public void user_navigates_to_daft_homepage_url() throws InterruptedException {
        logger.info("Navigating to url");
        hp=new HomePage(driver);
        hp.navigateToHomepage(TestBase.url);
    }

    @When("user searches for county {string} in the input field")
    public void user_searches_for_county_in_the_input_field(String location) throws InterruptedException {
        logger.info("Entering a specific location in the input");
        hp = new HomePage(driver);
        hp.enterDesiredLocation(location);
    }

    @And("user clicks on the desired location from the dropdown suggestions")
    public void user_clicks_on_the_desired_location_from_the_dropdown_suggestions() throws InterruptedException {
        logger.info("Clicking on the desired location from the the dropdown suggestions");
        hp.clickSuggestedLocation();
    }
}
