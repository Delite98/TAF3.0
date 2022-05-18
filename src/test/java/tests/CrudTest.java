package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.SideMenuPage;

import javax.swing.*;

public class CrudTest extends BaseTest {

    @Test
    public void CrudProjectTest() throws InterruptedException {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        sideMenuPage.getButtonAddProject().click();

        driver.findElement(By.id("name")).sendKeys("TestCreate");
        driver.findElement(By.id("announcement")).sendKeys("Test announcement");
        driver.findElement(By.id("suite_mode_single_baseline")).click();

        AddProjectPage addProjectPage = new AddProjectPage(driver);

        addProjectPage.getaccessLocator().click();
        WebElement DefaultAccess = driver.findElement(By.id("access"));
        Select selectDA = new Select(DefaultAccess);
        selectDA.selectByValue("1");

        addProjectPage.getdefectsLocator().click();

        addProjectPage.getreferencesLocator().click();

        addProjectPage.getuserVariablesLocator().click();
        driver.findElement(By.id("accept")).click();

        driver.findElement(By.id("navigation-dashboard")).click();
        driver.findElement(By.partialLinkText("TestCreate")).click();

        driver.findElement(By.id("navigation-milestones")).click();
        driver.findElement(By.partialLinkText("Add Milestone"));

    }

}