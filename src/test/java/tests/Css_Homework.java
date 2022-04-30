package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Css_Homework {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Check_Value_And_Name_Of_The_Goods() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement psw = driver.findElement(By.cssSelector("#password"));
        psw.sendKeys("secret_sauce");
        Thread.sleep(1000);
        WebElement buttonEnter = driver.findElement(By.cssSelector("#login-button"));
        buttonEnter.submit();
        Thread.sleep(1000);

        WebElement choice = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie"));
        choice.click();

        WebElement cart = driver.findElement(By.cssSelector("a>span"));
        cart.click();
        Thread.sleep(1000);

        WebElement examinationText = driver.findElement(By.cssSelector("[class='inventory_item_name']"));
        Assert.assertEquals(examinationText.getText(), "Sauce Labs Onesie");
        WebElement examinationPrice = driver.findElement(By.cssSelector("[class='inventory_item_price']"));
        Assert.assertEquals(examinationPrice.getText(), "$7.99");

        WebElement buttonCheckout = driver.findElement(By.cssSelector("[class='btn btn_action btn_medium checkout_button']"));
        buttonCheckout.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Darya");
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Sh");
        WebElement zipCode = driver.findElement(By.cssSelector("#postal-code"));
        zipCode.sendKeys("2222222");

        WebElement buttonContinue = driver.findElement(By.cssSelector("#continue"));
        Thread.sleep(3000);
    }
}
