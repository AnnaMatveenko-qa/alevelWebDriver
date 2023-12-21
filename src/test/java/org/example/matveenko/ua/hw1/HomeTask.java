package org.example.matveenko.ua.hw1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class HomeTask {

    @Test
    public void TestOne() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jobs.ua/");
        WebElement input = driver.findElement(By.xpath("//input [@name='q']"));
        input.clear();
        input.sendKeys("QA");
        WebElement button = driver.findElement(By.xpath("//button[@id='two-']"));
        button.click();
        driver.quit();
    }
}

