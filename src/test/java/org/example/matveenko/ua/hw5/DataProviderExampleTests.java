package org.example.matveenko.ua.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataProviderExampleTests {

    private WebDriver webDriver;

    @DataProvider(name = "Data")
    public Object[] searchData() {
        return new Object[]{
                "QA"
        };
    }


    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
      /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");*/
        webDriver = new ChromeDriver();
        webDriver.get("https://www.work.ua/");
        webDriver.manage().window().setSize(new Dimension(1600, 900));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterMethod
    public void after() {
        webDriver.quit();
        WebDriverManager.chromedriver().quit();
    }

    @Test(dataProvider = "Data")
    public void checkSearch(String data) {
        WebElement input = webDriver.findElement(By.id("search"));
        WebElement inputCity = webDriver.findElement(By.
                xpath("//div/input[@class='js-main-region form-control ']"));
        inputCity.click();
        inputCity.clear();
        inputCity.sendKeys("Вся Украина");
        input.sendKeys(data);
        input.sendKeys(Keys.ENTER);
        List<WebElement> links = webDriver.findElements(By.xpath("//h2[@class='cut-top cut-bottom']/a"));
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//h2[@class='cut-top cut-bottom']/a")));
        Assert.assertTrue(links.get(4).getText().toLowerCase().contains(data.toLowerCase()));
    }

}


