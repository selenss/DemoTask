package methods.base;

import methods.pages.stock.YahooConsentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
    private WebDriver driver;
    YahooConsentPage consentPage;

    @BeforeTest
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver");
        driver = new ChromeDriver();
        consentPage = new YahooConsentPage(getDriver());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://finance.yahoo.com/chart/NVDA");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        consentPage.clickRejectAllButton();
    }

    @AfterTest
    public void afterHook() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
