package org.example.matveenko.ua.hw4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task4 {
    @Test
    public void successfulSearch() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://eldorado.ua/uk/");
            WebElement element = driver.findElement(By.xpath("//div [@class='ui-library-stickyContainer-1244']"));
          Assert.assertTrue(element.isDisplayed());
           element.click();
            System.out.println("input is displayed – Assert passed");

        } finally {
            driver.quit();
        }
    }
}
