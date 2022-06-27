package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

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

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return project;
    }


}
