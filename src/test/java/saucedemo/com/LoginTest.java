package saucedemo.com;

import Pages.LoginPage;
import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

     WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        String baseUrl = "https://www.saucedemo.com/";
        driver.get(baseUrl);
    }

    @Test
    public void loginTest() {
        loginPage = new LoginPage(driver);

        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginBtn().click();

        mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.siteLabel().isDisplayed());
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
