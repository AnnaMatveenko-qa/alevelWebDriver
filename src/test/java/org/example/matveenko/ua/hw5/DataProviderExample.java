package org.example.matveenko.ua.hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderExample {
    private WebDriver webDriver;

    @DataProvider(name = "Data")
    public Object[] searchData() {
        return new Object[]{
                "QA",
                "Developer Java",
                "PM",
                "UI/UX"
        };
    }

    @BeforeMethod
    public void before() {
        webDriver = new ChromeDriver();
        webDriver.get("https://dou.ua/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterMethod
    public void after() {
        webDriver.quit();
    }

    @Test(dataProvider = "Data")
    public void checkSearch(String data) {
        WebElement input = webDriver.findElement(By.xpath("//input[@id='txtGlobalSearch']"));
        input.sendKeys(data);
        input.sendKeys(Keys.ENTER);
       
    }

}