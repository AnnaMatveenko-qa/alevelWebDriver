import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
    }

    @BeforeMethod
    public void InitDriver() throws RuntimeException {
        ChromeOptions options = new ChromeOptions();

       options.addArguments("--no-sandbox");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--windows-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--single-process");

        driver = new ChromeDriver(options);
       // driver.manage().window().setSize(new Dimension(1600, 900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://eldorado.ua/uk/holodilniki/c1061560/");


    }

    @AfterMethod
    public void TearDown() throws RuntimeException {
        driver.quit();

    }

    @AfterSuite
    public void tearDownClass() {
        WebDriverManager.chromedriver().quit();
    }
}
