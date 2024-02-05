package org.example.matveenko.ua.hw9;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static io.restassured.RestAssured.when;

public abstract class BaseTest {


    @BeforeMethod
    public void InitBaseURL() {
        RestAssured.baseURI = "https://api.github.com/";
    }

 /*   @Test
    public void checkResponseHasKey() {
        when().
                get("emojis").
        then()
                .statusCode(200)
                .body("articulated_lorry",h)
                .contentType(ContentType.JSON).extract().response();
        Assert.assertNotNull(response);
        System.out.println(response.jsonPath().getList("$"));


    }*/
}
