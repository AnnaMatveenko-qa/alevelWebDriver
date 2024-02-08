package org.example.matveenko.ua.hw9;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class EmojiTest {

    @BeforeMethod
    public void InitBaseURL() {
        RestAssured.baseURI = "https://api.github.com/";
    }

    @Test
    public void testResponseContainsArticulatedLorryKey() {

        given()
                .when()
                .get("emojis")
                .then()
                .statusCode(200)
                .body("articulated_lorry", notNullValue());
    }
}
