package methods.pages;

import methods.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
@FindBy( id = "content")
public WebElement something;
    public String method() {
        return something.getAttribute("class");
    }
}
