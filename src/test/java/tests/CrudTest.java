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
import pages.MilestonePage;
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
        MilestonePage milestonePage = new MilestonePage(driver);

        addProjectPage.getaccess().click();
        WebElement DefaultAccess = driver.findElement(By.id("access"));
        Select selectDA = new Select(DefaultAccess);
        selectDA.selectByValue("1");

        addProjectPage.getdefects().click();

        addProjectPage.getreferences().click();

        addProjectPage.getuserVariables().click();
        driver.findElement(By.id("accept")).click();

        driver.findElement(By.id("navigation-dashboard")).click();
        driver.findElement(By.partialLinkText("TestCreate")).click();

        driver.findElement(By.id("navigation-milestones")).click();
        driver.findElement(By.partialLinkText("Add Milestone")).click();

        milestonePage.getNameInputLocator().sendKeys("My name1");
        milestonePage.getReferencesInputLocator().sendKeys("Testing");
        milestonePage.getDescriptionInputLocator().sendKeys("Test text");
        milestonePage.getCompletedInputLocator().click();
        milestonePage.getAcceptButtonLocator().submit();

        driver.findElement(By.partialLinkText("My name1")).click();
        driver.findElement(By.partialLinkText("Edit")).click();
        driver.findElement(By.partialLinkText("Delete this milestone"));
    }

}
