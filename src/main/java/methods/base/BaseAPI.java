package methods.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    public BaseAPI() {
    }
    // API params
    public static String baseUrl = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3";
    public static String apiKey = "<your_api_key>";
    public static String host = "apidojo-yahoo-finance-v1.p.rapidapi.com";

    public static Logger log = LogManager.getLogger();

    // GET request structure
    public static Response performGet(String endpoint, Map<String, String> headers) {
        Response resp = given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .get(baseUrl + endpoint)
                .then()
                .extract().response();
        return resp;
    }
    @BeforeTest
    public void beforeSuite() {
        log.info("Test started");
    }

    @AfterTest
    public void afterHook() {
        log.info("Test completed");
    }

}
