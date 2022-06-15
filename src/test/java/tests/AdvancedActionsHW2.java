package tests;


import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

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

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(wait.waitForExists(By.id("tinymce")).getText(), "Your content goes here.");

    }
}
