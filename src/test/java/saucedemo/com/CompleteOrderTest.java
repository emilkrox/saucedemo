package saucedemo.com;

import Pages.*;
import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompleteOrderTest extends BaseClass {

    WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutFormPage checkoutFormPage;
    private OverviewPage overviewPage;
    private OrderCompletePage orderCompletePage;

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
        log.debug("Sample DEBUG message");
        log.error("Sample ERROR message");
        log.info("Sample INFO message");
        log.warn("Sample WARN message");

        loginPage = new LoginPage(driver);

        loginPage.loginInput().sendKeys("standard_user");
        loginPage.passwordInput().sendKeys("secret_sauce");
        loginPage.loginBtn().click();

        mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.siteLabel().isDisplayed());
    }

    @Test
    public void addToCardOneItemTest() {

        mainPage.addCartBackpackBtn().click();
        mainPage.cartBtn().click();

        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.cartLabel().isDisplayed());

    }

    @Test
    public void checkoutTest() {

        cartPage = new CartPage(driver);
        cartPage.checkoutBtn().click();

        checkoutFormPage = new CheckoutFormPage(driver);

        checkoutFormPage.firstNameInput().sendKeys("Jan");
        Assert.assertTrue(checkoutFormPage.firstNameInput().isDisplayed());
        checkoutFormPage.lastNameInput().sendKeys("Nowak");
        Assert.assertTrue(checkoutFormPage.lastNameInput().isDisplayed());
        checkoutFormPage.postalCodeInput().sendKeys("00-001");
        Assert.assertTrue(checkoutFormPage.continueBtn().isDisplayed());
        checkoutFormPage.continueBtn().click();

        overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.overviewLabel().isDisplayed());
    }

    @Test
    public void completeOrderTest() {

        overviewPage = new OverviewPage(driver);
        overviewPage.finishBtn().click();

        orderCompletePage = new OrderCompletePage(driver);

        Assert.assertEquals(orderCompletePage.completeOrderText().getText(), "THANK YOU FOR YOUR ORDER");

    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
