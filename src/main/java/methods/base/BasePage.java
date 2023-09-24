package methods.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    private static final int TIMEOUT = 15;

    protected WebDriver driver;
    public static String baseUrl = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3";
    public static String apiKey = "a6385b20cbmsh7244b7d3260e90ep1af974jsnf8ddc891417d";
    public static String host = "apidojo-yahoo-finance-v1.p.rapidapi.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public static String getRandomFromStringArr(String[] array) {
        int rnd = (int)(Math.random()*array.length);
        return array[rnd];
    }

    public String getElementText(WebElement elem) {
        return elem.getText();
    }
}
