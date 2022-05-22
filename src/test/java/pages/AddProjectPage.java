package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {

    @FindBy(id = "projects-tabs-project")
    public WebElement project;

    @FindBy(id = "projects-tabs-access")
    public WebElement access;

    @FindBy(id = "projects-tabs-defects")
    public WebElement defects;

    @FindBy(id = "projects-tabs-references")
    public WebElement references;

    @FindBy(id = "users-fields-fields")
    public WebElement userVariables;

    public WebElement getproject() {
        return project;
    }

    public WebElement getaccess() {
        return access;
    }

    public WebElement getdefects() {
        return defects;
    }

    public WebElement getreferences() {
        return references;
    }

    public WebElement getuserVariables() {
        return userVariables;
    }

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return null;
    }
}
