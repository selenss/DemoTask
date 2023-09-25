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
    public WebElement currencyInfo;

    // Methods
    public String checkCloseTimeInfo() {
        Waits.waitForElement(timezoneInfoText);
        return getElementText(timezoneInfoText);
    }

    public String checkCurrency() {
        Waits.waitForElement(currencyInfo);
        return getElementText(currencyInfo);
    }
}
