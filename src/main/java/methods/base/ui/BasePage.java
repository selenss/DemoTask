package methods.base.ui;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static io.restassured.RestAssured.given;

public class BasePage {
    private static final int TIMEOUT = 5;

    protected WebDriver driver;
    protected String baseUrl = "https://reqres.in/api/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public int getStatusCode(String url) {
        Response response = RestAssured.get(baseUrl + url);
        return response.getStatusCode();
    }

    public Response getBody(String url) {
        return given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get(baseUrl + url)
                .then()
                .extract().response();
    }
}
