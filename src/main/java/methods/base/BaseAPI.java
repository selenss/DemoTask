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
    public static String apiKey = "a6385b20cbmsh7244b7d3260e90ep1af974jsnf8ddc891417d";
    public static String host = "apidojo-yahoo-finance-v1.p.rapidapi.com";

    // GET request structure
    public static Response performGet(String endpoint, Map<String, String> headers) {
        Response response = given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .get(baseUrl + endpoint)
                .then()
                .extract().response();
        return response;
    }

}
