package test.login;

import methods.base.BaseTest;
import methods.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {
    LoginPage page;
    @BeforeTest
    public void  beforeTest() {
        page = new LoginPage(getDriver());
    }

    @Test
    public void testcase1() {
    Assert.assertEquals(page.method(), "large-12 columns");
    }

}
