package testBase;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;
	public static String url;

	public void selectBrowser(String browser) {

		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase(Browsers.HEADLESS.name())) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void propertyInitializer() throws IOException {

		logger= LogManager.getLogger(this.getClass());
		//Reading config.properties (for browser)
		FileReader file=new FileReader(System.getProperty("user.dir")+"/resources/config.properties");
		p=new Properties();
		p.load(file);
		url=p.getProperty("url");
	}
}
