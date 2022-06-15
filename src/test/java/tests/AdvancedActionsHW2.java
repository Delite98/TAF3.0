package tests;


import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class AdvancedActionsHW2 extends BaseTest {

    @Test
    public void alertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Homework^_^");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Homework^_^");
    }

    @Test
    public void iframeTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(wait.waitForExists(By.id("tinymce")).getText(), "Your content goes here.");

    }

    @Test
    public void jsExecutorFirstTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement select = driver.findElement(By.id("dropdown"));
        jsExecutor.executeScript("arguments[0].click();", select);
        driver.findElement(By.cssSelector("select>option:last-child")).click();

        Thread.sleep(5000);

    }

    @Test
    public void jsExecutorSecondTest() throws InterruptedException {
        driver.get("https://refactoring.guru/ru/design-patterns/builder");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("window.scrollBy(0,900)");

        Thread.sleep(5000);
    }

    @Test
    public void jsExecutorThirdTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dropdown");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("alert('This message is test message for alert with JavaScriptExecutor');");

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        jsExecutor.executeScript("alert('Alert was accepted');");
        Thread.sleep(2000);
    }
}
