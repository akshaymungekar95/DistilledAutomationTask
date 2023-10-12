//package stepDefinitions;
//
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.junit.Assert;
//import pageObjects.ResultsPage;
//import utilities.BrowserDriver;
//
//import static pageObjects.ResultsPage.*;
//
//
//public class ResultsPageSteps {
//
//    @Then("search results should be displayed for this location")
//    public void search_results_should_be_displayed_for_this_location() {
//        int count = setSearchResults();
//        if(count > 0) {
//            Assert.assertTrue(true);
//        }
//        else {
//            Assert.fail();
//        }
//    }
//    @When("user clicks on the filter option and applies the {string} filter")
//    public void user_clicks_on_the_filter_option_and_applies_the_filter(String filter) {
//        setClickFilter();
//        setScrollToElement();
//        setKeywordInputString(filter);
//        setClickShowResults();
//    }
//
//    @Then("search results should be displayed for the filter")
//    public void search_results_should_be_displayed_for_the_filter() {
//        int count = setSearchResults();
//        if(count > 0) {
//            Assert.assertTrue(true);
//        }
//        else {
//            Assert.fail();
//        }
//    }
//
//    @When("user opens a search result")
//    public void user_opens_a_search_result() {
//        clickOnFirstResult();
//    }
//
//}
