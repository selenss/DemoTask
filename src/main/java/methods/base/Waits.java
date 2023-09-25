package methods.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static methods.base.BasePage.driver;

public class Waits {
    public Waits() {
    }

    private static final int TIMEOUT = 10;

    public static void waitForElement(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }
}
