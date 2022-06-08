package tests;


import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedActionsHW2 extends BaseTest {

    @Test
    public void alertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Homework^_^");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Homework^_^");
    }

    @Test
    public void iframeTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");

    }
}
