package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public By searchInputLocator = By.id("search-box-input");
    public By dynamicSuggestionsLocator = By.xpath("//div/ul[@id='search-box-menu'and @role='listbox']/li");
    public By initialModalLocator = By.cssSelector("#didomi-notice-agree-button");

    public void navigateToHomepage(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();

        try {
            WebElement modalLocator = driver.findElement(initialModalLocator);
            modalLocator.click();
        }
        catch(Exception e) {
            System.out.println(e+" caused due to headless browser");
        }
    }
    public void enterDesiredLocation(String location) throws InterruptedException {
        WebElement locationInput = driver.findElement(searchInputLocator);
        locationInput.sendKeys(location);
    }
    public void clickSuggestedLocation() {
        List<WebElement> suggestedList = driver.findElements(dynamicSuggestionsLocator);

        for (WebElement element : suggestedList) {
            if(element.getText().contains("Dublin (County)")) {
                element.click();
                break;
            }
        }
    }
}
