package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.ResultsPage;
import testBase.TestBase;


public class ResultsPageSteps extends TestBase {
    ResultsPage rp;

    @Then("search results should be displayed for this location")
    public void search_results_should_be_displayed_for_this_location() throws InterruptedException {
        rp = new ResultsPage(driver);
        logger.info("Asserting the results count greater than 1");

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

        logger.info("Clicking on the filter option");
        rp.setClickFilter();

        rp.setScrollToElement();

        logger.info("Setting and applying the 'garage' keyword filter");
        rp.setKeywordInputString(filter);
        rp.setClickShowResults();
    }

    @Then("search results should be displayed for the filter")
    public void search_results_should_be_displayed_for_the_filter() {
        rp = new ResultsPage(driver);

        logger.info("Asserting the results count greater than 1, after applying the filter");
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
        Thread.sleep(1000);
        rp = new ResultsPage(driver);
        rp.setScrollToFirstResultElement();

        logger.info("Clicking on the first result displayed after applying the filter");
        rp.clickOnFirstResult();
    }
}