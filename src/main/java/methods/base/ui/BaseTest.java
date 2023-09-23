package methods.base.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Array;

public class BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterTest
    public void afterHook() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
