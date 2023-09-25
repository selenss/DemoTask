package test.stock.api;

import io.restassured.response.Response;
import methods.base.BaseAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import static methods.base.BasePage.getRandomFromStringArr;

public class StockTestsAPI extends BaseAPI {
    String[] intervals = {"1m", "2m", "5m", "15m", "30m", "60m", "1d", "1wk", "1mo"};
    String[] symbols = {"NVDA"};
    String[] ranges = {"1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd", "max"};
    String[] regions = {"US", "BR", "AU", "CA", "FR", "DE", "HK", "IN", "IT", "ES", "GB", "SG"};

    @Test (enabled = false)
    public void checkRangeInfoByRandomParams() {
        // Test data
        String interval = getRandomFromStringArr(intervals);
        String symbol = getRandomFromStringArr(symbols);
        String range = getRandomFromStringArr(ranges);
        String region = getRandomFromStringArr(regions);
        String endpoint = "/get-chart?interval="+ interval + "&symbol= " + symbol + "&range=" + range + "&region=" + region;
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-RapidAPI-Key", BaseAPI.apiKey);
        headers.put("X-RapidAPI-Host",BaseAPI.host);
        // Test Execution and Results
        Response response = performGet(endpoint,headers);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.range"), "[" + range + "]");
    }

    @Test
    public void checkSymbolInfoByCustomParams() {
        // Test data
        String endpoint = "/get-chart?interval=1mo&symbol=NVDA&range=5y&region=US";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-RapidAPI-Key", BaseAPI.apiKey);
        headers.put("X-RapidAPI-Host",BaseAPI.host);
        // Test Execution and Results
        Response response = performGet(endpoint,headers);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.symbol[0]"), "NVDA");
    }

    @Test
    public void checkCurrencyInfoByCustomParams() {
        // Test data
        String endpoint = "/get-chart?interval=1mo&symbol=NVDA&range=5y&region=US";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("X-RapidAPI-Key", BaseAPI.apiKey);
        headers.put("X-RapidAPI-Host",BaseAPI.host);
        // Test Execution and Results
        Response response = performGet(endpoint,headers);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("chart.result.meta.currency[0]"), "USD");
    }
}
