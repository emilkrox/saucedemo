package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement loginInput() {
        return driver.findElement(By.xpath("//input[@id='user-name']"));
    }

    public WebElement passwordInput() {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement loginBtn() {
        return driver.findElement(By.xpath("//input[@id='login-button']"));
    }

}
