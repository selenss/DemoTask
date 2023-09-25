package test.stock.ui;


import io.restassured.response.Response;
import methods.base.BaseTest;
import methods.base.BaseAPI;
import methods.pages.stock.StockPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class StockTestsUI extends BaseTest {
    //StockPage stockPage;
    Response response;
    StockPage stockPage;

    @BeforeTest
    public void  beforeTest() {
        stockPage = new StockPage(getDriver());
        // Test data
        String endpoint = "/get-chart?interval=1mo&symbol=NVDA&range=5y&region=US";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-RapidAPI-Key", BaseAPI.apiKey);
        headers.put("X-RapidAPI-Host",BaseAPI.host);
        // Test Data Validation
        response = BaseAPI.performGet(endpoint,headers);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkSymbolInfoUI() {
        String timezoneInfoText = stockPage.getCloseTimeInfo();
        Assert.assertTrue(timezoneInfoText.contains(response.jsonPath().getString("chart.result.meta.timezone[0]")));
    }

    @Test
    public void checkCurrencyInfo() {
        String currencyInfoText = stockPage.getCurrency();
        Assert.assertTrue(currencyInfoText.contains(response.jsonPath().getString("chart.result.meta.currency[0]")));
    }

}