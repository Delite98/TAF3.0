package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class xPath_Homework {
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

        WebElement username = driver.findElement(By.xpath("//*[@id = 'user-name']"));
        username.sendKeys("standard_user");
        WebElement psw = driver.findElement(By.xpath("//*[@id = 'password']"));
        psw.sendKeys("secret_sauce");
        Thread.sleep(1000);
        WebElement buttonEnter = driver.findElement(By.xpath("//*[@id = 'login-button']"));
        buttonEnter.submit();
        Thread.sleep(1000);

        WebElement choiceGoods = driver.findElement(By.xpath("//*[@id = 'add-to-cart-sauce-labs-onesie']"));
        choiceGoods.click();

        WebElement cart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
        cart.click();
        Thread.sleep(1000);

        WebElement examinationText = driver.findElement(By.xpath("//*[@id='item_2_title_link']/div"));
        Assert.assertEquals(examinationText.getText(), "Sauce Labs Onesie");
        WebElement examinationPrice = driver.findElement(By.xpath("//*[@id='item_2_title_link']/parent::div/child::div[2]/div"));
        Assert.assertEquals(examinationPrice.getText(), "$7.99");

        WebElement buttonCheckout = driver.findElement(By.xpath("//*[@id='checkout']"));
        buttonCheckout.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.xpath("//*[@id='first-name']"));
        firstName.sendKeys("Darya");
        WebElement lastName = driver.findElement(By.xpath("//*[@id='last-name']"));
        lastName.sendKeys("Sh");
        WebElement zipCode = driver.findElement(By.xpath("//*[@id='postal-code']"));
        zipCode.sendKeys("2222222");

        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id='continue']"));
        Thread.sleep(3000);
    }
}
