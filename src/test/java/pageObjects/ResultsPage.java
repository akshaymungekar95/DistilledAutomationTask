package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }
    public By resultsLocator = By.xpath("//ul[@data-testid=\"results\"]/li[contains(@data-testid, " +
                                                        "'result')]");
    public By filterLocator = By.cssSelector("button[aria-label='Filters']");
    public By showResultsLocator = By.cssSelector("button[data-testid='filters-modal-show-results-button']");
    public By keywordInputLocator = By.cssSelector("#keywordtermsModal");
    public By firstSearchResultLocator = By.xpath("//ul[@data-testid=\"results\"]/li[1]");


    public int setSearchResults() {
        List<WebElement> resultsList = driver.findElements(resultsLocator);
        return resultsList.size();
    }

    public void setClickFilter() {
        WebElement filter = driver.findElement(filterLocator);
        filter.click();
    }

    public void setScrollToFirstResultElement() {
        try {
            WebElement elementToScroll = driver.findElement(firstSearchResultLocator);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        }
        catch (Exception e) {
            System.out.println(e+" caused due to headless browser");
        }
    }

    public void setScrollToElement() {
        try {

            WebElement elementToScroll = driver.findElement(showResultsLocator);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
        }
        catch (Exception e) {
            System.out.println(e+" caused due to headless browser");
        }
    }

    public void setKeywordInputString(String filter) {

        WebElement keywordInput = driver.findElement(keywordInputLocator);
        keywordInput.sendKeys(filter);
    }

    public void setClickShowResults() {
        WebElement showResults = driver.findElement(showResultsLocator);
        showResults.click();
    }

    public void clickOnFirstResult() {
        try {
            WebElement firstResult = driver.findElement(firstSearchResultLocator);
            wait.until(ExpectedConditions.visibilityOf(firstResult));

            firstResult.click();
        }
        catch (Exception e) {
            System.out.println(e+" It must be due to headless browser");
        }
    }
}
