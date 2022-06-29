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
    public void CrudProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        MilestonePage milestonePage = new MilestonePage(driver);
        String nameOfMyProject = "I'm trying create this prooooject...";

        loginPage.successLogin(ReadProperties.username(), ReadProperties.password());
        sideMenuPage
                .buttonAddProject()
                .getInputName(nameOfMyProject)
                .getAnnouncement("Test announcement")
                .getSuitMode()
                .accessChapter()
                .getDefaultAccess("3")
                .defectsChapter()
                .referencesChapter()
                .userVariablesChapter()
                .getAcceptButton()
                .navigateDashboardButton()
                .openMyProject(nameOfMyProject);

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
