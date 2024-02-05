package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class StartPage extends BasePage {
    @FindBy(xpath = "//div/p[@class='ui-library-body2Regular-7f98']")
    private List<WebElement> catalogSectionNames;
    private Header header;

    public StartPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
    }


    public boolean isPresentOnStartPage() {
        catalogSectionNames.get(0).isDisplayed();
        return true;
    }
}
