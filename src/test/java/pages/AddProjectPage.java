package pages;

import baseEntities.BasePage;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonPOJOBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddProjectPage extends BasePage {
    private By projectLocator = By.id("projects-tabs-project");
    private By accessLocator = By.id("projects-tabs-access");
    private By defectsLocator = By.id("projects-tabs-defects");
    private By referencesLocator = By.id("projects-tabs-references");
    private By userVariablesLocator = By.id("users-fields-fields");
    private By inputNameEntry = By.id("name");
    private By announcementEntry = By.id("announcement");
    private By suitModeChoice = By.id("suite_mode_single");
    private By defaultAccessChoice = By.id("access");
    private By acceptButton = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public AddProjectPage accessChapter() {
        driver.findElement(accessLocator).click();
        return this;
    }

    public AddProjectPage defectsChapter() {
        driver.findElement(defectsLocator).click();
        return this;
    }

    public AddProjectPage referencesChapter() {
        driver.findElement(referencesLocator).click();
        return this;
    }

    public AddProjectPage userVariablesChapter() {
        driver.findElement(userVariablesLocator).click();
        return this;
    }

    public AddProjectPage getInputName(String nameStatic){
        driver.findElement(inputNameEntry).sendKeys(nameStatic);
        return this;
    }

    public AddProjectPage getAnnouncement(String announcement){
        driver.findElement(announcementEntry).sendKeys(announcement);
        return this;
    }

    public AddProjectPage getSuitMode(){
        driver.findElement(suitModeChoice).click();
        return this;
    }

    public AddProjectPage getDefaultAccess(String value) {
        WebElement tSuitModeChoice = driver.findElement(defaultAccessChoice);
        Select selectDA = new Select(tSuitModeChoice);
        selectDA.selectByValue(value);
        return this;
    }

    public ProjectsPage getAcceptButton() {
        driver.findElement(acceptButton).click();
        return new ProjectsPage (driver);
    }
}
