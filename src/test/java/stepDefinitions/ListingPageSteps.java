package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.ListingPage;
import testBase.TestBase;
import org.junit.Assert;

public class ListingPageSteps extends TestBase {
    ListingPage lp;

    @Then("advert description should contain the {string} keyword")
    public void advert_description_should_contain_the_keyword(String filter) throws InterruptedException {
        lp = new ListingPage(driver);

        logger.info("Checks and handles if there is any survey popup present");
        lp.hideSurvey();

        lp.setScrollToDescElement();

        logger.info("Asserting the presence of 'garage' keyword under the property description");
        boolean result1 = lp.setCapturePropertyDescription(filter);

        lp.setScrollToPropertyElement();

        logger.info("Asserting the presence of 'garage' keyword under the property features");
        boolean result2 = lp.setCapturePropertyFeatures(filter);

        if (result1 || result2) {
            logger.info("Asserting the existence of 'garage' keyword based on the results obtained");
            // Test will fail if none of the above results (result1 or result2) contain the keyword 'garage'
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}
