package test.stock.ui;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import methods.base.BasePage;
import methods.base.BaseTest;
import methods.pages.stock.StockPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class StockTestsUI extends BaseTest {
    StockPage page;
    @BeforeTest
    public void  beforeTest() {
        page = new StockPage(getDriver());
    }
    @Test
    public void checkSymbolInfoUI() {
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
        Assert.assertEquals(page.checkSymbolInfo(), response.jsonPath().getString("chart.result.meta.symbol[0]"));
    }

    @Test
    public void checkCurrencyInfo() {
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
        Assert.assertTrue(page.checkCurrency().contains(response.jsonPath().getString("chart.result.meta.currency[0]")));
    }
}