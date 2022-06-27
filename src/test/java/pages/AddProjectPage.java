package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private By projectLocator = By.id("projects-tabs-project");
    private By accessLocator = By.id("projects-tabs-access");
    private By defectsLocator = By.id("projects-tabs-defects");
    private By referencesLocator = By.id("projects-tabs-references");
    private By userVariablesLocator = By.id("users-fields-fields");

    public WebElement getprojectLocator(){
        return driver.findElement(projectLocator);
    }
    public WebElement getaccessLocator(){
        return driver.findElement(accessLocator);
    }
    public WebElement getdefectsLocator(){
        return driver.findElement(defectsLocator);
    }
    public WebElement getreferencesLocator(){
        return driver.findElement(referencesLocator);
    }
    public WebElement getuserVariablesLocator(){
        return driver.findElement(userVariablesLocator);
    }

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

}
