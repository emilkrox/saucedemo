package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement siteLabel() {
        return driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
    }

    public WebElement cartBtn() {
        return driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
    }

    public WebElement addCartBackpackBtn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    }

    public WebElement addCartBikeLightsBtn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    }

    public WebElement addCartBoltTShirt_Btn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
    }

    public WebElement addCartJacketBtn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
    }

    public WebElement addCartOnesieBtn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
    }

    public WebElement addCartRedTShirtBtn() {
        return driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
    }
}
