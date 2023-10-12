//package stepDefinitions;
//
//import io.cucumber.java.en.*;
//import org.junit.Assert;
//import pageObjects.ListingPage;
//
//import static pageObjects.ListingPage.*;
//
//
//public class ListingPageSteps {
//
//
//    @Then("advert description should contain the {string} keyword")
//    public void advert_description_should_contain_the_keyword(String filter) {
//        setScrollToDescElement();
//        boolean result1 = setCapturePropertyDescription(filter);
//
//        setScrollToPropertyElement();
//        boolean result2 = setCapturePropertyFeatures(filter);
//        if (result1 || result2) {
//            Assert.assertTrue(true);
//        }
//        else {
//            Assert.fail();
//        }
//    }
//}
