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
import services.WaitsService;

import javax.swing.*;
import java.time.Duration;

public class CrudTest extends BaseTest {

    @Test
    public void CrudProjectTest() throws InterruptedException {
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        sideMenuPage.getButtonAddProject().click();

        WebElement name = wait.waitForVisibilityLocatedBy(By.id("name"));
        name.sendKeys("TestCreate");

        WebElement announcement = wait.waitForVisibilityLocatedBy(By.id("announcement"));
        announcement.sendKeys("Test announcement");

        WebElement suiteMode = wait.waitForVisibilityLocatedBy(By.id("suite_mode_single_baseline"));
        suiteMode.click();

        AddProjectPage addProjectPage = new AddProjectPage(driver);
        MilestonePage milestonePage = new MilestonePage(driver);

        addProjectPage.getaccessLocator().click();
        WebElement DefaultAccess = wait.waitForVisibilityLocatedBy(By.id("access"));
        Select selectDA = new Select(DefaultAccess);
        selectDA.selectByValue("1");

        addProjectPage.getdefectsLocator().click();

        addProjectPage.getreferencesLocator().click();

        addProjectPage.getuserVariablesLocator().click();
        WebElement accept = wait.waitForVisibilityLocatedBy(By.id("accept"));
        accept.click();

        WebElement navigationDashboard = wait.waitForVisibilityLocatedBy(By.id("navigation-dashboard"));
        navigationDashboard.click();

        WebElement TestCreate = wait.waitForVisibilityLocatedBy(By.partialLinkText("TestCreate"));
        TestCreate.click();

        WebElement navigationMilestones = wait.waitForExists(By.id("navigation-milestones"));
        navigationMilestones.click();

        WebElement addMilestone = wait.waitForExists(By.partialLinkText("Add Milestone"));
        addMilestone.click();

        milestonePage.getNameInputLocator().sendKeys("My name1");
        milestonePage.getReferencesInputLocator().sendKeys("Testing");
        milestonePage.getDescriptionInputLocator().sendKeys("Test text");
        milestonePage.getCompletedInputLocator().click();
        milestonePage.getAcceptButtonLocator().submit();

        WebElement writeText = wait.waitForVisibilityLocatedBy(By.partialLinkText("My name1"));
        writeText.click();

        WebElement editText = wait.waitForVisibilityLocatedBy(By.partialLinkText("Edit"));
        editText.click();

        WebElement deleteText = wait.waitForVisibilityLocatedBy(By.partialLinkText("Delete this milestone"));
        deleteText.click();

        WebElement deleteCheckBox = wait.waitForVisibilityLocatedBy(By.cssSelector("label span+span+input[name='deleteCheckbox']"));
        deleteCheckBox.click();

        WebElement deleteAccept = wait.waitForExists(By.cssSelector("#deleteDialog div[class*='button']>a:first-child"));
        deleteAccept.click();
    }
}
