package methods.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    public BaseAPI() {
    }
    // API params
    public static String baseUrl = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3";
    public static String apiKey = "<your_api_key>";
    public static String host = "apidojo-yahoo-finance-v1.p.rapidapi.com";

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

}
