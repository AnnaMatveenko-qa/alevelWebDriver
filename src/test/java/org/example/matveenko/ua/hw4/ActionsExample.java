package org.example.matveenko.ua.hw4;

import matveenko.ua.lesson2.hw4.DuoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class ActionsExample {
    private WebDriver webDriver;

    @BeforeTest
    public void before() {
        webDriver = new ChromeDriver();
        webDriver.get("https://dou.ua/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterTest
    public void after() {
        webDriver.quit();
    }

    @Test
    public void test1() {
        DuoPage duoPage = new DuoPage(webDriver);
        String actual = duoPage.getLinkText();
        String expected = "Мінус 683 вакансії за місяць. Огляд IT-ринку праці, грудень 2023";
        boolean result = Objects.equals(actual, expected);
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        DuoPage duoPage = new DuoPage(webDriver);
        duoPage.clickLink();
    }
}

