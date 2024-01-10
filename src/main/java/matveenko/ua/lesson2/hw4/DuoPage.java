package matveenko.ua.lesson2.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuoPage {
    private WebDriver driver;

    public DuoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@id='fp-articles_recent']/li[7]/a[@class='link ']")
    private WebElement link;

    public String getLinkText()
    {
        return link.getText();
    }

    public void clickLink()
    {
        new Actions(driver).click(link).build().perform();
    }
}

