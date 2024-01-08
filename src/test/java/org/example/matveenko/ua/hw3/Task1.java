package org.example.matveenko.ua.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {
    @Test
    public void successfulSearchInput() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://accounts.google.com/");
            WebElement input = driver.findElement(By.xpath("//input[@id='identifierId']"));
            Assert.assertTrue(input.isDisplayed());
            System.out.println("input is displayed – Assert passed");
        } finally {
            driver.quit();
        }
    }


    @Test
    public void checkPlaceholderInput() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://accounts.google.com/");
            WebElement input = driver.findElement(By.xpath("//input[@id='identifierId']"));
            Assert.assertTrue(input.isDisplayed());
            System.out.println("input is displayed – Assert passed");
            Boolean checked = checkAttribute(input);
            Assert.assertFalse(checked);
            System.out.println("input has`t attribute 'placeholder'");
        } finally {
            driver.quit();
        }
    }

    private boolean checkAttribute(WebElement element) {
        Boolean result = false;
        try {
            String value = element.getAttribute("placeholder");
            if (value != null) {
                if (!value.isEmpty()) {
                    result = true;
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Test
    public void checkValidMessage() {
        WebDriver driver = new ChromeDriver();
        try {
            String message = "Enter a valid email or phone number";
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://accounts.google.com/");
            WebElement input = driver.findElement(By.xpath("//input[@id='identifierId']"));
            Assert.assertTrue(input.isDisplayed());
            input.sendKeys("5789");
            System.out.println("input is displayed – Assert passed");
            WebElement button = driver.findElement(By.xpath("//div[@id='identifierNext']/div/button"));
            Assert.assertTrue(button.isEnabled());
            System.out.println("button is enabled – Assert passed");
            button.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).
                    until(ExpectedConditions.presenceOfElementLocated(By
                            .xpath("//div[@role='presentation']//div[@aria-live='assertive']/div")));
            Assert.assertTrue(driver.findElement(By
                            .xpath("//div[@role='presentation']//div[@aria-live='assertive']/div"))
                    .isDisplayed());
            Assert.assertEquals(message, driver.findElement(By
                    .xpath("//div[@role='presentation']//div[@aria-live='assertive']/div")).getText());
            System.out.println(driver.findElement(By
                    .xpath("//div[@role='presentation']//div[@aria-live='assertive']/div")).getText());
        } finally {
            driver.quit();
        }
    }
}