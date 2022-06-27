package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.LoginPage;
import pages.MilestonePage;
import pages.SideMenuPage;

public class CrudTest extends BaseTest {

    @Test
    public void CrudProjectTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        MilestonePage milestonePage = new MilestonePage(driver);

        loginPage.successLogin(ReadProperties.username(), ReadProperties.password());
        sideMenuPage.buttonAddProject();

        driver.findElement(By.id("name")).sendKeys("TestCreate");
        driver.findElement(By.id("announcement")).sendKeys("Test announcement");
        driver.findElement(By.id("suite_mode_single_baseline")).click();

        addProjectPage.accessChapter();
        WebElement DefaultAccess = driver.findElement(By.id("access"));
        Select selectDA = new Select(DefaultAccess);
        selectDA.selectByValue("1");

        addProjectPage.defectsChapter();

        addProjectPage.referencesChapter();

        addProjectPage.userVariablesChapter();
        driver.findElement(By.id("accept")).click();

        driver.findElement(By.id("navigation-dashboard")).click();
        driver.findElement(By.partialLinkText("TestCreate")).click();

        driver.findElement(By.id("navigation-milestones")).click();
        driver.findElement(By.partialLinkText("Add Milestone")).click();

        milestonePage
                .nameInput()
                .referencesInput()
                .descriptionInput()
                .completedInput()
                .acceptButton();

        driver.get("https://aqa1804.testrail.io/index.php?/milestones/view/224"); //согласна, перебор, но у меня закончились идеи:(
        driver.findElement(By.partialLinkText("Edit")).click();
        driver.findElement(By.partialLinkText("Delete this milestone"));
    }

}
