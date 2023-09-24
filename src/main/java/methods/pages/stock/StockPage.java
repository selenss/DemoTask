package methods.pages.stock;

import methods.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StockPage extends BasePage {

    public StockPage(WebDriver driver) {
        super(driver);
    }
    @FindBy( css = "span.ciql-symbol")
    public WebElement symbolButtonText;

    @FindBy( xpath = "//translate[contains(text(),'Currency in ')]")
    public WebElement currencyInfo;

    public String checkSymbolInfo() {
        return getElementText(symbolButtonText);
    }

    public String checkCurrency() {
        return getElementText(currencyInfo);
    }

}
