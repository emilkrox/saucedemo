package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFormPage {

    WebDriver driver;

    public CheckoutFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement firstNameInput() {
        return driver.findElement(By.xpath("//input[@id='first-name']"));
    }

    public WebElement lastNameInput() {
        return driver.findElement(By.xpath("//input[@id='last-name']"));
    }

    public WebElement postalCodeInput() {
        return driver.findElement(By.xpath("//input[@id='postal-code']"));
    }

    public WebElement continueBtn() {
        return driver.findElement(By.xpath("//input[@id='continue']"));
    }
}
