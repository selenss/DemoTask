package test.ui.login;

import methods.base.ui.BaseTest;
import methods.pages.ui.login.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginUITests extends BaseTest {
    LoginPage page;
    @BeforeTest
    public void  beforeTest() {
        page = new LoginPage(getDriver());
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(page.method(), "large-12 columns");
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(page.method(), "large-12 columns");
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(page.getStatusCode("users?page=2"), 200);
    }
}
