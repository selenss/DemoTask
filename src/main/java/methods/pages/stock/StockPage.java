package methods.pages.stock;

import methods.base.BasePage;
import methods.base.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StockPage extends BasePage {

    public StockPage(WebDriver driver) {
        super(driver);
    }
    // Selectors
    @FindBy( css = "div#quote-market-notice > span")
    public WebElement timezoneInfoText;

    @FindBy( xpath = "//translate[contains(text(),'Currency in ')]")
    public WebElement currencyInfoText;

    // Methods
    public String getCloseTimeInfo() {
        Waits.waitForElement(timezoneInfoText);
        return getElementText(timezoneInfoText);
    }

    public String getCurrency() {
        Waits.waitForElement(currencyInfoText);
        return getElementText(currencyInfoText);
    }
}
