package methods.base;

import methods.pages.stock.YahooConsentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    private WebDriver driver;
    public static Logger log = LogManager.getLogger();
    YahooConsentPage consentPage;

    @Parameters("browser")
    @BeforeTest
    public void beforeSuite(String browser) {
        String os = System.getProperty("os.name");
        if(os.contains("Mac")) {
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/macOS/geckodriver");
                driver = new FirefoxDriver();

            }
            else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/macOS/chromedriver");
                driver = new ChromeDriver();
            }
        }
        else if(os.contains("Windows")) {
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/windowsOS/geckodriver.exe");
                driver = new FirefoxDriver();

            }
            else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/windowsOS/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }

        else {
            throw new IllegalArgumentException("Please download Firefox and/or Chrome browsers");
        }
        consentPage = new YahooConsentPage(getDriver());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://finance.yahoo.com/chart/NVDA");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        consentPage.clickRejectAllButton();
        log.info("Test started");
    }

    @AfterTest
    public void afterHook() {
        log.info("Test completed");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
