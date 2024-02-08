package org.example.matveenko.ua.hw4;


import io.github.bonigarcia.wdm.WebDriverManager;
import matveenko.ua.lesson2.hw4.DuoPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class ActionsExampleTest {
    private WebDriver driver;

@BeforeSuite
public void setUp(){
    WebDriverManager.chromedriver().clearDriverCache().setup();
    WebDriverManager.chromedriver().clearResolutionCache().setup();
}

    @BeforeTest
    @BeforeMethod
    public void InitDriver() throws RuntimeException {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get("https://dou.ua/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @AfterTest
    public void after() {
        driver.quit();

    }
@AfterSuite
public void tearDown(){
    WebDriverManager.chromedriver().quit();
}
    @Test
    public void test1() {
        DuoPage duoPage = new DuoPage(driver);
        String actual = duoPage.getLinkText(0);
        String expected = "Мінус 683 вакансії за місяць. Огляд IT-ринку праці, грудень 2023";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void test2() {
        DuoPage duoPage = new DuoPage(driver);
        duoPage.clickLink(5);
    }
}

