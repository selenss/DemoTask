package methods.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://finance.yahoo.com/chart/NVDA");
    }

    @AfterTest
    public void afterHook() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
