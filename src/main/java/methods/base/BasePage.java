package methods.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class BasePage {
    private static final int TIMEOUT = 15;

    protected static WebDriver driver;

    // Common methods
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public static String getRandomIndexValueFromStringArr(String[] array) {
        int rnd = (int)(Math.random()*array.length);
        return array[rnd];
    }

    public String getElementText(WebElement elem) {
        return elem.getText();
    }
}
