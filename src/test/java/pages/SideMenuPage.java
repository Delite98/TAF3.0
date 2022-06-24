package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuPage extends BasePage {

    @FindBy (id = "sidebar")
    public WebElement sidebar;

    @FindBy (id = "sidebar-projects-add")
    public WebElement buttonAddProject;

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return sidebar;
    }

}
