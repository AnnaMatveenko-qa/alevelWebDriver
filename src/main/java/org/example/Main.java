package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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

