package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import javax.swing.*;
import java.time.Duration;

public class AdvancedActionsHW extends BaseTest{

    @Test
    public void contextMenuTest(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        actions.contextClick(driver.findElement(By.id("hot-spot")));
                actions.build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControls(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkBox = driver.findElement(By.cssSelector("form div input"));
        checkBox.click();
        driver.findElement(By.cssSelector("div+button")).click();
        WebElement itsGone = wait.waitForVisibilityLocatedBy(By.id("message"));
        Assert.assertEquals(itsGone.getText(), "It's gone!");
        wait.waitForElementInvisible(checkBox);

        WebElement inputButton = driver.findElement(By.cssSelector("form input"));
        Assert.assertFalse(inputButton.isEnabled());
        driver.findElement(By.cssSelector("form input+button")).click();
        wait.waitForVisibilityLocatedBy(By.cssSelector("form input+button+p"));
        Assert.assertTrue(inputButton.isEnabled());

    }

}
