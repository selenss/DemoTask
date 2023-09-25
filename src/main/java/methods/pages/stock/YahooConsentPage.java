package methods.pages.stock;

import methods.base.BasePage;
import methods.base.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooConsentPage extends BasePage {

    public YahooConsentPage(WebDriver driver) {
        super(driver);
    }
    // Selectors
    @FindBy( css = "button.reject-all")
    public static WebElement rejectAllButton;


    // Methods
    public void clickRejectAllButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", rejectAllButton);
        Waits.waitForElement(rejectAllButton);
        rejectAllButton.click();
    }




}
