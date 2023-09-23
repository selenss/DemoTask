package methods.pages.ui.login;

import methods.base.ui.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
@FindBy( id = "content")
public WebElement something;
    public String method() {
        return something.getAttribute("class");
    }


    // API Methods
    public int checkUrlStatusCode(String url) {
        return getStatusCode(url);
    }
}
