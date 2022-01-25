package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement cartLabel() {
        return driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]"));
    }

    public WebElement checkoutBtn() {
        return driver.findElement(By.xpath("//button[@id='checkout']"));
    }
}
