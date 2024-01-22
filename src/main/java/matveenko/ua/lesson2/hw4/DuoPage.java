package matveenko.ua.lesson2.hw4;

import org.checkerframework.common.value.qual.IntRange;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuoPage {
    private WebDriver driver;

    public DuoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@id='fp-articles_recent']//a[@class='link ']")
    private List<WebElement> links;

    public String getLinkText(int index)
    {
        return links.get(index).getText();
    }

    public void clickLink(int index)
    {
        new Actions(driver).click(links.get(index)).build().perform();
    }
}

