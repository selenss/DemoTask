package test.stock.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import methods.base.BasePage;
import methods.base.BaseTest;
import methods.pages.stock.StockPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static methods.base.BasePage.getRandomFromStringArr;

public class StockTestsAPI extends BaseTest {
    String[] intervals = {"1m", "2m", "5m", "15m", "30m", "60m", "1d", "1wk", "1mo"};
    String[] symbols = {"NVDA"};
    String[] ranges = {"1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd", "max"};
    String[] regions = {"US", "BR", "AU", "CA", "FR", "DE", "HK", "IN", "IT", "ES", "GB", "SG"};
    StockPage page;
    @BeforeTest
    public void  beforeTest() {
        page = new StockPage(getDriver());
    }
    @Test(enabled = false, description = "selected params are not same as in response")
    public void checkRangeInfoByRandomParams() {
        String endpoint = "/get-chart";
        String interval = getRandomFromStringArr(intervals);
        String symbol = getRandomFromStringArr(symbols);
        String range = getRandomFromStringArr(ranges);
        String region = getRandomFromStringArr(regions);
        Response response = given()
                .header("X-RapidAPI-Key", BasePage.apiKey)
                .header("X-RapidAPI-Host",BasePage.host)
                .contentType(ContentType.JSON)
                .param("interval", interval)
                .param("symbol", symbol)
                .param("range", range)
                .param("region", region)
                .when()
                .get(BasePage.baseUrl + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.range"), "[" + range + "]");
    }

    @Test(enabled = false, description = "selected params are not same as in response")
    public void checkIntervalInfoByRandomParams() {
        String endpoint = "/get-chart";
        String interval = getRandomFromStringArr(intervals);
        String symbol = getRandomFromStringArr(symbols);
        String range = getRandomFromStringArr(ranges);
        String region = getRandomFromStringArr(regions);
        Response response = given()
                .header("X-RapidAPI-Key", BasePage.apiKey)
                .header("X-RapidAPI-Host",BasePage.host)
                .contentType(ContentType.JSON)
                .param("interval", interval)
                .param("symbol", symbol)
                .param("range", range)
                .param("region", region)
                .when()
                .get(BasePage.baseUrl + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.dataGranularity"), "[" + interval + "]");
    }

    @Test
    public void checkSymbolInfoByCustomParams() {
        String endpoint = "/get-chart";
        Response response = given()
                .header("X-RapidAPI-Key", BasePage.apiKey)
                .header("X-RapidAPI-Host",BasePage.host)
                .contentType(ContentType.JSON)
                .param("interval", "1mo")
                .param("symbol", "NVDA")
                .param("range", "5y")
                .param("region", "US")
                .when()
                .get(BasePage.baseUrl + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.symbol[0]"), "NVDA");
    }

    @Test
    public void checkCurrencyInfoByCustomParams() {
        String endpoint = "/get-chart";
        Response response = given()
                .header("X-RapidAPI-Key", BasePage.apiKey)
                .header("X-RapidAPI-Host",BasePage.host)
                .contentType(ContentType.JSON)
                .param("interval", "1mo")
                .param("symbol", "NVDA")
                .param("range", "5y")
                .param("region", "US")
                .when()
                .get(BasePage.baseUrl + endpoint)
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.currency[0]"), "USD");
    }
}
