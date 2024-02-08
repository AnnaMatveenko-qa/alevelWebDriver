package org.example.matveenko.ua.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;

import java.util.List;


public class DataProviderExampleTests {

    private WebDriver driver;

    @DataProvider(name = "Data")
    public Object[] searchData() {
        return new Object[]{
                "QA"
        };
    }


    @BeforeMethod
    public void InitDriver() throws RuntimeException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://www.work.ua/");



    }

    @AfterMethod
    public void after() {
        driver.quit();
        WebDriverManager.chromedriver().quit();
    }

    @Test(dataProvider = "Data")
    public void checkSearch(String data) {
        WebElement input = driver.findElement(By.id("search"));
        WebElement inputCity = driver.findElement(By.
                xpath("//div/input[@class='js-main-region form-control ']"));
        inputCity.click();
        inputCity.clear();
        inputCity.sendKeys("Вся Украина");
        input.sendKeys(data);
        input.sendKeys(Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//h2[@class='cut-top cut-bottom']/a"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//h2[@class='cut-top cut-bottom']/a")));
        Assert.assertTrue(links.get(4).getText().toLowerCase().contains(data.toLowerCase()));
    }

}


