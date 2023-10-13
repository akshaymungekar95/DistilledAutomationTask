package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ListingPage extends BasePage {

    public ListingPage(WebDriver driver) {
        super(driver);
    }
    public By lastPropertyFeatureLocator = By.xpath("//div[@data-testid='features']/ul/li[last()]");
    public By propertyFeaturesLocator = By.xpath("//div[@data-testid='features']/ul/li");
    public By propertyDescriptionLocator = By.xpath("//div[@data-testid='description']/child::div[@data-testid='description']");
    public By hideSurveyLocator = By.cssSelector("button[aria-label=\"Hide survey\"]");


    public void setScrollToDescElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(propertyDescriptionLocator));

        WebElement elementToScroll = driver.findElement(propertyDescriptionLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }

    public void setScrollToPropertyElement() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastPropertyFeatureLocator));

        WebElement elementToScroll = driver.findElement(lastPropertyFeatureLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }

    public boolean setCapturePropertyFeatures(String filter) {
        List<WebElement> propertyFeatures = driver.findElements(propertyFeaturesLocator);
        boolean flag = false;
        for (WebElement propFeature : propertyFeatures) {
            System.out.println(propFeature.getText());
            if (propFeature.getText().toLowerCase().contains(filter.toLowerCase())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean setCapturePropertyDescription(String filter) {
        WebElement propertyDesc = driver.findElement(propertyDescriptionLocator);
        System.out.println(propertyDesc.getText());
        return propertyDesc.getText().toLowerCase().contains(filter.toLowerCase());
    }

    public void hideSurvey() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(hideSurveyLocator));
            WebElement hideSurvey = driver.findElement(hideSurveyLocator);
            hideSurvey.click();
        }
        catch (Exception e) {
            System.out.println(e+" caused due to headless browser");
        }
    }
}
