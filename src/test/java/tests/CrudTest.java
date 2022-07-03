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

import javax.xml.transform.sax.SAXResult;

public class CrudTest extends BaseTest {

    @Test
    public void CrudProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        SideMenuPage sideMenuPage = new SideMenuPage(driver);
        MilestonePage milestonePage = new MilestonePage(driver);
        String nameOfMyPr = "I'm trying create this prooooject...";

        loginPage.successLogin(ReadProperties.username(), ReadProperties.password());
        sideMenuPage
                .buttonAddProject()
                .getInputName(nameOfMyPr)
                .getAnnouncement("Test announcement")
                .getSuitMode()
                .accessChapter()
                .getDefaultAccess("3")
                .defectsChapter()
                .referencesChapter()
                .userVariablesChapter()
                .getAcceptButton()
                .navigateDashboardButton()
                .openMyProject()
                .navigationToMilestones();
        driver.findElement(By.partialLinkText(nameOfMyPr)).click();
        String myProjectUrlIndex = String.valueOf(driver.getCurrentUrl().lastIndexOf(7));

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
