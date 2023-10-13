package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.ListingPage;
import pageObjects.ResultsPage;
import testBase.TestBase;
import org.junit.Assert;


public class ListingPageSteps extends TestBase {
    ListingPage lp;
    ResultsPage rp;

@Then("advert description should contain the {string} keyword")
public void advert_description_should_contain_the_keyword(String filter) throws InterruptedException {
        rp = new ResultsPage(driver);
        rp.setScrollToFirstResultElement();
        rp.clickOnFirstResult();

        Thread.sleep(2000);

        lp = new ListingPage(driver);
        lp.hideSurvey();

        Thread.sleep(2000);

        lp.setScrollToDescElement();

        boolean result1 = lp.setCapturePropertyDescription(filter);


        lp.setScrollToPropertyElement();
        boolean result2 = lp.setCapturePropertyFeatures(filter);


        if (result1 || result2) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
