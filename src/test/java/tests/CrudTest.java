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

        driver.findElement(By.id("name")).sendKeys("DaryaS");
        driver.findElement(By.id("announcement")).sendKeys("Test announcement");
        driver.findElement(By.id("suite_mode_single_baseline")).click();

        AddProjectPage addProjectPage = new AddProjectPage(driver);

        addProjectPage.getaccessLocator().click();
        WebElement DefaultAccess = driver.findElement(By.id("access"));
        Select selectDA = new Select(DefaultAccess);
        selectDA.selectByValue("3");

        addProjectPage.getdefectsLocator().click();
        driver.findElement(By.id("defect_id_url")).sendKeys("defectid.url");
        driver.findElement(By.id("defect_add_url")).sendKeys("defectadd.url");


        addProjectPage.getreferencesLocator().click();
        driver.findElement(By.id("reference_id_url")).sendKeys("referencesid.url");
        driver.findElement(By.id("reference_add_url")).sendKeys("referenceadd.url");


        addProjectPage.getuserVariablesLocator().click();
        driver.findElement(By.id("accept")).click();

    }

}
